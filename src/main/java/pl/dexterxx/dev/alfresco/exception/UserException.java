package pl.dexterxx.dev.alfresco.exception;

/**
 * The Class UserException.
 */
public class UserException extends AlfrescoServiceException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 3595946830238681190L;

    /**
     * Instantiates a new user exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public UserException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new user exception.
     *
     * @param message the message
     */
    public UserException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new user exception.
     *
     * @param cause the cause
     */
    public UserException(final Throwable cause) {
        super(cause);
    }

}
