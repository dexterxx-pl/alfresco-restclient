package pl.dexterxx.dev.alfresco.service;

import feign.error.ErrorHandling;
import pl.dexterxx.dev.alfresco.dto.content.ContentNode;
import pl.dexterxx.dev.alfresco.dto.user.AddUser;
import pl.dexterxx.dev.alfresco.dto.user.ChangePassword;
import pl.dexterxx.dev.alfresco.dto.user.SearchUserResponse;
import pl.dexterxx.dev.alfresco.dto.user.User;
import pl.dexterxx.dev.alfresco.exception.UserException;
import pl.dexterxx.dev.alfresco.resource.UserResource;

/**
 * The Class UserService.
 */
@ErrorHandling(defaultException = UserException.class)
public class UserService extends AbstractService<UserResource> {

    /**
     * Instantiates a new user service.
     *
     * @param restBaseUri the rest base uri
     * @param authTicket  the auth ticket
     */
    public UserService(final String restBaseUri, final String authTicket) {
        super(restBaseUri, authTicket);
    }

    /*
     * @see Service#getResourceClass()
     */
    @Override
    protected Class<UserResource> getResourceClass() {
        return UserResource.class;
    }

    /**
     * Gets the users.
     *
     * @param filter     the filter
     * @param maxResults the max results
     * @return the users
     * @throws UserException the user exception
     */
    public SearchUserResponse getUsers(final String filter, final int maxResults)
            throws UserException {
        return resourceProxy.getUsers(authTicket, filter, maxResults);
    }

    /**
     * Gets the user.
     *
     * @param username the username
     * @return the user
     * @throws UserException the user exception
     */
    public User getUser(final String username) throws UserException {
        return resourceProxy.getUser(authTicket, username);
    }

    /**
     * Creates the user.
     *
     * @param userDetails the user details
     * @return the user
     * @throws UserException the user exception
     */
    public User createUser(final AddUser userDetails) throws UserException {
        return resourceProxy.createUser(authTicket, userDetails);
    }

    /**
     * Delete user.
     *
     * @param userName the user name
     * @throws UserException the user exception
     */
    public void deleteUser(final String userName) throws UserException {
        resourceProxy.deleteUser(authTicket, userName);
    }

    /**
     * Change password.
     *
     * @param userName    the user name
     * @param oldPassword the old password
     * @param newPassword the new password
     * @throws UserException the user exception
     */
    public void changePassword(final String userName, final String oldPassword,
                               final String newPassword) throws UserException {
        final ChangePassword changePassword = new ChangePassword();
        changePassword.setOldPassword(oldPassword);
        changePassword.setNewPassword(newPassword);
        resourceProxy.changePassword(authTicket, userName, changePassword);
    }

    /**
     * Update user.
     *
     * @param username    the username
     * @param userDetails the user details
     * @return the string
     * @throws UserException the user exception
     */
    public String updateUser(final String username, final User userDetails)
            throws UserException {
        return resourceProxy.updateUser(authTicket, username, userDetails);
    }

    /**
     * Gets the user home.
     *
     * @param username the username
     * @return the user home
     * @throws UserException the user exception
     */
    public ContentNode getUserHome(final String username)
            throws UserException {
        return resourceProxy.getUserHome(authTicket, username);
    }

}