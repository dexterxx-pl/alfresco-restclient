package pl.dexterxx.dev.alfresco.dto.content;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class NodeUpdateStatus.
 */
public class NodeUpdateStatus {

    /**
     * The status.
     */
    @JsonProperty("success")
    private boolean status;

    /**
     * Checks if is status.
     *
     * @return true, if is status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(final boolean status) {
        this.status = status;
    }

}
