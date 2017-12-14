package pl.dexterxx.dev.alfresco.dto.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dexterxx.dev.alfresco.dto.BaseDto;
import pl.dexterxx.dev.alfresco.dto.common.UserRole;

/**
 * The Class Permission.
 */
public class Permission extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The role.
     */
    @JsonProperty("role")
    private UserRole role;

    /**
     * The authority.
     */
    @JsonProperty("authority")
    private String authority;

    /**
     * The remove.
     */
    @JsonProperty("remove")
    private boolean remove;

    /**
     * Gets the role.
     *
     * @return the role
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Sets the role.
     *
     * @param role the new role
     */
    public void setRole(final UserRole role) {
        this.role = role;
    }

    /**
     * Gets the authority (User or Group).Group names are prefixed by GROUP_
     *
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * Sets the authority (User or Group). Group names must be prefixed by GROUP_
     *
     * @param authority the new authority
     */
    public void setAuthority(final String authority) {
        this.authority = authority;
    }

    /**
     * Checks if is removes the.
     *
     * @return true, if is removes the
     */
    public boolean isRemove() {
        return remove;
    }

    /**
     * Sets the removes the.
     *
     * @param remove the new removes the
     */
    public void setRemove(final boolean remove) {
        this.remove = remove;
    }

}
