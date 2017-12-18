package pl.dexterxx.dev.alfresco.client;

import feign.Feign;
import feign.Request;
import feign.codec.Decoder;
import feign.error.AnnotationErrorDecoder;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import feign.slf4j.Slf4jLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.dexterxx.dev.alfresco.commons.MediaType;
import pl.dexterxx.dev.alfresco.feign.MultipleDecoder;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class Service.
 *
 * @param <R> the generic type
 */
public abstract class Service<R extends Resource> {

    /**
     * The logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(Service.class);

    /**
     * The rest base uri.
     */
    private final String restBaseUri;

    /**
     * The resource proxy.
     */
    protected final R resourceProxy;

    /**
     * Read timeout (in seconds)
     */
    private static final int HTTP_SOCKET_TIMEOUT = 100 * 1000;

    /**
     * Connection timeout (in seconds)
     */
    private static final int HTTP_CONNECTION_TIMEOUT = 10 * 1000;

    /**
     * Contains supported by client media types.
     * In out alfresco case we must support JSON and XML.
     */
    private Map<MediaType, Decoder> supportedMediaTypes = new HashMap<>();

    // TODO(dexterxx)
    //static {
    //    initializeProviderFactory();
    //}

    /**
     * Instantiates a new service.
     *
     * @param restBaseUri the rest base uri
     */
    public Service(final String restBaseUri) {
        this.supportedMediaTypes.put(MediaType.APPLICATION_XML_TYPE, new Decoder.Default()); // StringDecoder
        this.supportedMediaTypes.put(MediaType.APPLICATION_JSON_TYPE, new JacksonDecoder());

        this.restBaseUri = restBaseUri;
        this.resourceProxy = getResourceProxy(getResourceClass(), restBaseUri);
    }

    // TODO(dexterxx) + restore providers
    //private static void initializeProviderFactory() {
    //    try {
    //        final ResteasyProviderFactory providerFactory = ResteasyProviderFactory.getInstance();
    //        registerResteasyProvider(providerFactory, DocumentContentProvider.class);
    //        registerResteasyProvider(providerFactory, HtmlBodyReader.class);
    //        registerResteasyProvider(providerFactory, MultipartFormAnnotationWriter.class);
    //        RegisterBuiltin.register(providerFactory);
    //    } catch (final Exception e) {
    //        logger.error("Error occurred while registering custom resteasy providers", e);
    //    }
    //}

    // TODO(dexterxx)
    //private static void registerResteasyProvider(final ResteasyProviderFactory providerFactory, final Class<?> providerClass) {
    //    logger.info("Registering custom Provider with Resteasy:" + providerClass.getName() + " ...");
    //    providerFactory.registerProvider(providerClass);
    //    logger.info("Registered custom Provider with Resteasy:" + providerClass.getName());
    //}

    /**
     * Gets the resource class.
     *
     * @return the resource class
     */
    protected abstract Class<R> getResourceClass();

    /**
     * Gets the resource proxy.
     *
     * @param <T>       the generic resource type
     * @param clazz     the resource class
     * @param serverUri the server uri
     * @return the resource proxy
     */
    protected <T> T getResourceProxy(final Class<T> clazz,
                                     final String serverUri) {
        return getClientService(clazz, serverUri);
    }

    /**
     * Gets the client service.
     *
     * @param <T>       the generic type
     * @param clazz     the clazz
     * @param serverUri the server uri
     * @return the client service
     */
    private <T> T getClientService(final Class<T> clazz,
                                   final String serverUri) {
        logger.info("Generating REST resource proxy for: " + clazz.getName() + ": {} url with timeouts {}/{}",
                serverUri, HTTP_CONNECTION_TIMEOUT, HTTP_SOCKET_TIMEOUT);

        return Feign.builder()
                .logger(new Slf4jLogger(clazz))
                .contract(new JAXRSContract())
                .options(new Request.Options(HTTP_CONNECTION_TIMEOUT, HTTP_SOCKET_TIMEOUT))
                .errorDecoder(AnnotationErrorDecoder.builderFor(clazz).build())
                .encoder(new FormEncoder(new JacksonEncoder()))
                .decoder(new MultipleDecoder(supportedMediaTypes, MediaType.APPLICATION_XML_TYPE))
                .target(clazz, serverUri);
    }

    public String getRestBaseUri() {
        return restBaseUri;
    }
}
