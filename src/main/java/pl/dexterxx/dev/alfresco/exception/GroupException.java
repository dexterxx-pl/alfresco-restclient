package pl.dexterxx.dev.alfresco.exception;

/**
 * The Class GroupException.
 */
public class GroupException extends AlfrescoServiceException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -1943453715951536242L;

    /**
     * Instantiates a new group exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public GroupException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new group exception.
     *
     * @param message the message
     */
    public GroupException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new group exception.
     *
     * @param cause the cause
     */
    public GroupException(final Throwable cause) {
        super(cause);
    }

}
