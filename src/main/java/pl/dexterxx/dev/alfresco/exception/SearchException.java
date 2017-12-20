package pl.dexterxx.dev.alfresco.exception;

/**
 * The Class SearchException.
 */
public class SearchException extends AlfrescoServiceException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -286710296075135967L;

    /**
     * Instantiates a new search exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public SearchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new search exception.
     *
     * @param message the message
     */
    public SearchException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new search exception.
     *
     * @param cause the cause
     */
    public SearchException(final Throwable cause) {
        super(cause);
    }

}
