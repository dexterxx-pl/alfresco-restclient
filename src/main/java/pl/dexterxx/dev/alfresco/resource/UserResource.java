package pl.dexterxx.dev.alfresco.resource;

import pl.dexterxx.dev.alfresco.client.Resource;
import pl.dexterxx.dev.alfresco.commons.AlfrescoConstants;
import pl.dexterxx.dev.alfresco.dto.content.ContentNode;
import pl.dexterxx.dev.alfresco.dto.user.AddUser;
import pl.dexterxx.dev.alfresco.dto.user.ChangePassword;
import pl.dexterxx.dev.alfresco.dto.user.SearchUserResponse;
import pl.dexterxx.dev.alfresco.dto.user.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * The Interface UserResource.
 */
@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface UserResource extends Resource {

    /**
     * Gets the users.
     *
     * @param ticket     the ticket
     * @param filter     the filter
     * @param maxResults the max results
     * @return the users
     */
    @GET
    @Path("people")
    @Produces(MediaType.APPLICATION_JSON)
    SearchUserResponse getUsers(
            @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @QueryParam("filter") String filter,
            @QueryParam("maxResults") int maxResults);

    /**
     * Gets the user.
     *
     * @param ticket   the ticket
     * @param username the username
     * @return the user
     */
    @GET
    @Path("people/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    User getUser(
            @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @PathParam("username") String username);

    /**
     * Creates the user.
     *
     * @param ticket the ticket
     * @param user   the user
     * @return the client response
     */
    @POST
    @Path("people")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    User createUser(
            @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            AddUser user);

    /**
     * Change password.
     *
     * @param ticket         the ticket
     * @param username       the username
     * @param changePassword the change password
     * @return the client response
     */
    @POST
    @Path("person/changepassword/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String changePassword(
            @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @PathParam("username") String username,
            ChangePassword changePassword);

    /**
     * Delete user.
     *
     * @param ticket   the ticket
     * @param username the username
     * @return the client response
     */
    @DELETE
    @Path("people/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    String deleteUser(
            @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @PathParam("username") String username);

    /**
     * Update user.
     *
     * @param ticket   the ticket
     * @param username the username
     * @param user     the user
     * @return the client response
     */
    @PUT
    @Path("people/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String updateUser(
            @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @PathParam("username") String username, User user);

    /**
     * Gets the user home.
     *
     * @param ticket   the ticket
     * @param username the username
     * @return the user home
     */
    @GET
    @Path("people/{username}/home")
    @Produces(MediaType.APPLICATION_JSON)
    ContentNode getUserHome(
            @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @PathParam("username") String username);

}
