package pl.dexterxx.dev.alfresco.dto.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dexterxx.dev.alfresco.dto.BaseDto;

import java.util.List;

/**
 * The Class ServiceResponse.
 */
public class ServiceResponse extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -5904389506284205882L;

    /**
     * The status.
     */
    @JsonProperty
    private ServiceResponseStatus status;

    /**
     * The message.
     */
    @JsonProperty("message")
    private String message;

    /**
     * The exception.
     */
    @JsonProperty
    private String exception;

    /**
     * The callstack.
     */
    @JsonProperty
    private List<String> callstack;

    /**
     * The server.
     */
    @JsonProperty
    private String server;

    /**
     * The time.
     */
    @JsonProperty
    private String time;

    /**
     * Gets the status.
     *
     * @return the status
     */
    public ServiceResponseStatus getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(final ServiceResponseStatus status) {
        this.status = status;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * Gets the exception.
     *
     * @return the exception
     */
    public String getException() {
        return exception;
    }

    /**
     * Sets the exception.
     *
     * @param exception the new exception
     */
    public void setException(final String exception) {
        this.exception = exception;
    }

    /**
     * Gets the callstack.
     *
     * @return the callstack
     */
    public List<String> getCallstack() {
        return callstack;
    }

    /**
     * Sets the callstack.
     *
     * @param callstack the new callstack
     */
    public void setCallstack(final List<String> callstack) {
        this.callstack = callstack;
    }

    /**
     * Gets the server.
     *
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * Sets the server.
     *
     * @param server the new server
     */
    public void setServer(final String server) {
        this.server = server;
    }

    /**
     * Gets the time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time.
     *
     * @param time the new time
     */
    public void setTime(final String time) {
        this.time = time;
    }

}