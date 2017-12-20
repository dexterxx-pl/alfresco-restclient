package pl.dexterxx.dev.alfresco.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Timestamp.
 */
public class Timestamp extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 8819886316476271464L;

    /**
     * The iso8601.
     */
    @JsonProperty
    private String iso8601;

    /**
     * Gets the iso8601.
     *
     * @return the iso8601
     */
    public String getIso8601() {
        return iso8601;
    }

    /**
     * Sets the iso8601.
     *
     * @param iso8601 the new iso8601
     */
    public void setIso8601(String iso8601) {
        this.iso8601 = iso8601;
    }

}
