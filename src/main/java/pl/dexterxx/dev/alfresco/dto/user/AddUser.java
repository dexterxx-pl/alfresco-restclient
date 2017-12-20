package pl.dexterxx.dev.alfresco.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The Class AddUser.
 */
public class AddUser extends BaseUser {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -6927986043823113155L;

    /**
     * The user name.
     */
    @JsonProperty("userName")
    private String userName;

    /**
     * The password.
     */
    @JsonProperty("password")
    private String password;

    /**
     * The email.
     */
    @JsonProperty("email")
    private String email;

    /**
     * The quota.
     */
    @JsonProperty("quota")
    private int quota;

    /**
     * The groups.
     */
    @JsonProperty("groups")
    private List<String> groups;

    /**
     * Gets the user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     *
     * @param userName the new user name
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Gets the quota.
     *
     * @return the quota
     */
    public int getQuota() {
        return quota;
    }

    /**
     * Sets the quota.
     *
     * @param quota the new quota
     */
    public void setQuota(final int quota) {
        this.quota = quota;
    }

    /**
     * Gets the groups.
     *
     * @return the groups
     */
    public List<String> getGroups() {
        return groups;
    }

    /**
     * Sets the groups.
     *
     * @param groups the new groups
     */
    public void setGroups(final List<String> groups) {
        this.groups = groups;
    }

}
