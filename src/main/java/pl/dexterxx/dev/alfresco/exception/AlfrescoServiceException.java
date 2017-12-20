package pl.dexterxx.dev.alfresco.exception;

import pl.dexterxx.dev.alfresco.dto.error.ServiceResponse;

/**
 * The Class AlfrescoServiceException.
 */
public class AlfrescoServiceException extends Exception {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -6081873510684510L;

    /**
     * The error response.
     */
    private ServiceResponse errorResponse;

    /**
     * Instantiates a new alfresco service exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public AlfrescoServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new alfresco service exception.
     *
     * @param message the message
     */
    public AlfrescoServiceException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new alfresco service exception.
     *
     * @param cause the cause
     */
    public AlfrescoServiceException(final Throwable cause) {
        super(cause);
    }

    /**
     * Gets the error response.
     *
     * @return the error response
     */
    public ServiceResponse getErrorResponse() {
        return errorResponse;
    }

    /**
     * Sets the error response.
     *
     * @param errorResponse the new error response
     */
    public void setErrorResponse(final ServiceResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

}
