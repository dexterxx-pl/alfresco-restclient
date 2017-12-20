package pl.dexterxx.dev.alfresco.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Credentials.
 */
public class Credentials extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -6492209613647675748L;

    /**
     * The username.
     */
    @JsonProperty(value = "username")
    private final String username;

    /**
     * The password.
     */
    @JsonProperty(value = "password")
    private final String password;


    /**
     * Instantiates a new credentials.
     *
     * @param username the username
     * @param password the password
     */
    public Credentials(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }


    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }


}
