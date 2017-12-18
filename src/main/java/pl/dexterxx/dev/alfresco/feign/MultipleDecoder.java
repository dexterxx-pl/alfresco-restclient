package pl.dexterxx.dev.alfresco.feign;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.dexterxx.dev.alfresco.commons.MediaType;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Allows to support many decoders in OpenFeign. It allows to specify media type which should be decoded
 * with specified decoder. If nothing match or there'll be any exceptions it fires up default decoder.
 * Endpoint must return "content-type" in response header.
 *
 * @author Kamil Komorek (admin@dexterxx.pl)
 */
public class MultipleDecoder implements Decoder {

    private Logger log = LoggerFactory.getLogger(MultipleDecoder.class);

    private Map<MediaType, Decoder> decoderMap;

    private Decoder defaultDecoder;

    public MultipleDecoder(Map<MediaType, Decoder> decoders, MediaType defaultMediaType) {
        this(decoders, decoders.get(defaultMediaType));
    }

    public MultipleDecoder(Map<MediaType, Decoder> decoders, Decoder defaultDecoder) {
        this.decoderMap = Collections.unmodifiableMap(decoders);
        this.defaultDecoder = defaultDecoder;

        if (this.defaultDecoder == null) {
            throw new IllegalArgumentException("default decoder cannot be null");
        }
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        Optional<String> first = response.headers().keySet().stream()
                .filter(s -> s.equalsIgnoreCase("content-type"))
                .findFirst();

        if (first.isPresent()) {
            String headerKey = first.get();
            String headerValue = response.headers().get(headerKey).stream()
                    .collect(Collectors.joining(","));

            MediaType matchedMediaType = MediaType.valueOf(headerValue);

            if (matchedMediaType != null) {
                Decoder decoder = decoderMap.getOrDefault(matchedMediaType, defaultDecoder);
                return decoder.decode(response, type);
            }

            for (Map.Entry<MediaType, Decoder> entry : decoderMap.entrySet()) {
                if (entry.getKey().toString().contains(headerValue)) {
                    return entry.getValue().decode(response, type);
                }
            }
        } else {
            log.warn("MultipleDecoder not found content-type for request {}", response.request().toString());
        }

        // still nothing or no content-type in header - fire default
        return defaultDecoder.decode(response, type);
    }
}
