package pl.dexterxx.dev.alfresco.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class AuthenticationData.
 */
public class AuthenticationData extends BaseDto {

    private static final long serialVersionUID = -7392801586069757290L;

    /**
     * The authentication token.
     */
    @JsonProperty("ticket")
    private String authenticationToken;

    /**
     * Gets the authentication token.
     *
     * @return the authentication token
     */
    public String getAuthenticationToken() {
        return authenticationToken;
    }

    /**
     * Sets the authentication token.
     *
     * @param authenticationToken the new authentication token
     */
    public void setAuthenticationToken(final String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

}
