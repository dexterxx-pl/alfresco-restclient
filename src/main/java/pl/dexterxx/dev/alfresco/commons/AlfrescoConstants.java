package pl.dexterxx.dev.alfresco.commons;

/**
 * The Interface AlfrescoConstants.
 */
public class AlfrescoConstants {

    /**
     * The resource context base path.
     */
    public static final String RESOURCE_CONTEXT_BASE_PATH = "/alfresco/service/api/";

    /**
     * The auth ticket param name.
     */
    public static final String AUTH_TICKET_PARAM_NAME = "alf_ticket";

    /**
     * The default store type.
     */
    public static final String DEFAULT_STORE_TYPE = "workspace";

    /**
     * The default store id.
     */
    public static final String DEFAULT_STORE_ID = "SpacesStore";

    /**
     * The default store.
     */
    public static final String DEFAULT_STORE = DEFAULT_STORE_TYPE + "://" + DEFAULT_STORE_ID;
}
