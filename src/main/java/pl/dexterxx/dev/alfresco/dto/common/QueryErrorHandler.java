package pl.dexterxx.dev.alfresco.dto.common;

/**
 * The Enum QueryErrorHandler.
 */
public enum QueryErrorHandler {

    /**
     * The exception.
     */
    EXCEPTION("exception"),

    /**
     * The no results.
     */
    NO_RESULTS("no-results");

    /**
     * The name.
     */
    private String name;

    /**
     * Instantiates a new query error handler.
     *
     * @param name the name
     */
    private QueryErrorHandler(final String name) {
        this.name = name;
    }

    /* 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return name;
    }
}
