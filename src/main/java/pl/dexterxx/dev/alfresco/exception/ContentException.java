package pl.dexterxx.dev.alfresco.exception;

/**
 * The Class ContentException.
 */
public class ContentException extends AlfrescoServiceException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 3640290970017128491L;

    /**
     * Instantiates a new content exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ContentException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new content exception.
     *
     * @param message the message
     */
    public ContentException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new content exception.
     *
     * @param cause the cause
     */
    public ContentException(final Throwable cause) {
        super(cause);
    }

}
