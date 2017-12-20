package pl.dexterxx.dev.alfresco.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class AuthResponse.
 */
public class AuthResponse extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -7068550765006421642L;

    /**
     * The authentication data.
     */
    @JsonProperty("data")
    private AuthenticationData authenticationData;

    /**
     * Gets the authentication data.
     *
     * @return the authentication data
     */
    public AuthenticationData getAuthenticationData() {
        return authenticationData;
    }

    /**
     * Sets the authentication data.
     *
     * @param authenticationData the new authentication data
     */
    public void setAuthenticationData(AuthenticationData authenticationData) {
        this.authenticationData = authenticationData;
    }

}
