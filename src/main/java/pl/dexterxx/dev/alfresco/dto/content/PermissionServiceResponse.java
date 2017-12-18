package pl.dexterxx.dev.alfresco.dto.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dexterxx.dev.alfresco.dto.BaseDto;

public class PermissionServiceResponse extends BaseDto {

    private static final long serialVersionUID = -654561625581877974L;

    @JsonProperty("permissionStatus")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}