package pl.dexterxx.dev.alfresco.exception;

/**
 * The Class PermissionException.
 */
public class PermissionException extends AlfrescoServiceException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 2845061589650300820L;

    /**
     * Instantiates a new permission exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public PermissionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new permission exception.
     *
     * @param message the message
     */
    public PermissionException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new permission exception.
     *
     * @param cause the cause
     */
    public PermissionException(final Throwable cause) {
        super(cause);
    }

}
