package pl.dexterxx.dev.alfresco.exception;

/**
 * The Class AuthenticationException.
 */
public class AuthenticationException extends AlfrescoServiceException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -3096312307287591027L;

    /**
     * Instantiates a new authentication exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public AuthenticationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new authentication exception.
     *
     * @param message the message
     */
    public AuthenticationException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new authentication exception.
     *
     * @param cause the cause
     */
    public AuthenticationException(final Throwable cause) {
        super(cause);
    }

}
