package pl.dexterxx.dev.alfresco.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dexterxx.dev.alfresco.dto.BaseDto;

/**
 * The Class UserCapabilities.
 */
public class UserCapabilities extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1663942471397952257L;

    /**
     * The is mutable.
     */
    @JsonProperty
    private boolean isMutable;

    /**
     * The is guest.
     */
    @JsonProperty
    private boolean isGuest;

    /**
     * The is admin.
     */
    @JsonProperty
    private boolean isAdmin;

    /**
     * Checks if is mutable.
     *
     * @return true, if is mutable
     */
    public boolean isMutable() {
        return isMutable;
    }

    /**
     * Sets the mutable.
     *
     * @param isMutable the new mutable
     */
    public void setMutable(final boolean isMutable) {
        this.isMutable = isMutable;
    }

    /**
     * Checks if is guest.
     *
     * @return true, if is guest
     */
    public boolean isGuest() {
        return isGuest;
    }

    /**
     * Sets the guest.
     *
     * @param isGuest the new guest
     */
    public void setGuest(final boolean isGuest) {
        this.isGuest = isGuest;
    }

    /**
     * Checks if is admin.
     *
     * @return true, if is admin
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Sets the admin.
     *
     * @param isAdmin the new admin
     */
    public void setAdmin(final boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
