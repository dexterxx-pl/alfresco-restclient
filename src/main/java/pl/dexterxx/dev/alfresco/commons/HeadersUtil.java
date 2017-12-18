package pl.dexterxx.dev.alfresco.commons;

import org.apache.tika.metadata.HttpHeaders;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Helpers related to HTTP Headers.
 *
 * @author Kamil Komorek (kkomorek@bluesoft.net.pl)
 */
public class HeadersUtil {

    public static Optional<String> findFirstHeaderValueIgnoreCase(Map<String, Collection<String>> headers,
                                                                  String httpHeaderKey) {
        Optional<String> header = headers.keySet()
                .stream()
                .filter(httpHeaderKey::equalsIgnoreCase)
                .findFirst();

        return header.map(s -> headers.get(s)
                .stream()
                .collect(Collectors.joining(";")));
    }

    public static Optional<String> findContentType(Map<String, Collection<String>> headers) {
        return findFirstHeaderValueIgnoreCase(headers, HttpHeaders.CONTENT_TYPE);
    }

}
