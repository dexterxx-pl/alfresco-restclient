package pl.dexterxx.dev.alfresco.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dexterxx.dev.alfresco.dto.BaseDto;

/**
 * The Class ChangePassword.
 */
public class ChangePassword extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -1117653125171397058L;

    /**
     * The old password.
     */
    @JsonProperty("oldpw")
    private String oldPassword;

    /**
     * The new password.
     */
    @JsonProperty("newpw")
    private String newPassword;

    /**
     * Gets the old password.
     *
     * @return the old password
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * Sets the old password.
     *
     * @param oldPassword the new old password
     */
    public void setOldPassword(final String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * Gets the new password.
     *
     * @return the new password
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Sets the new password.
     *
     * @param newPassword the new new password
     */
    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }

}
