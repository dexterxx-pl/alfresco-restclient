package pl.dexterxx.dev.alfresco.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dexterxx.dev.alfresco.dto.BaseDto;

import java.util.List;

/**
 * The Class SearchUserResponse.
 */
public class SearchUserResponse extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -7759949462365660224L;

    /**
     * The users.
     */
    @JsonProperty("people")
    private List<User> users;

    /**
     * Gets the users.
     *
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Sets the users.
     *
     * @param users the new users
     */
    public void setUsers(final List<User> users) {
        this.users = users;
    }

}
