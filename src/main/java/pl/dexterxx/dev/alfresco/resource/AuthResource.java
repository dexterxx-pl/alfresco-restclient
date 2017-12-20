package pl.dexterxx.dev.alfresco.resource;

import pl.dexterxx.dev.alfresco.client.Resource;
import pl.dexterxx.dev.alfresco.commons.AlfrescoConstants;
import pl.dexterxx.dev.alfresco.dto.AuthResponse;
import pl.dexterxx.dev.alfresco.dto.Credentials;
import pl.dexterxx.dev.alfresco.dto.error.ServiceResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * The Interface AuthResource.
 */
@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface AuthResource extends Resource {

    /**
     * Login.
     *
     * @param credentials the credentials
     * @return the client response
     */
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    AuthResponse login(Credentials credentials);

    /**
     * Logout.
     *
     * @param ticket         the ticket
     * @param authTicket     the auth ticket
     * @param responseFormat the response format
     * @return the client response
     */
    @DELETE
    @Path("login/ticket/{ticket}")
    @Produces(MediaType.APPLICATION_JSON)
    ServiceResponse logout(
            @PathParam("ticket") String ticket,
            @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String authTicket,
            @QueryParam("format") String responseFormat);

    /**
     * Validate ticket.
     *
     * @param ticket         the ticket
     * @param authTicket     the ticket TODO(dexterxx) ??
     * @param responseFormat response format which is requested to be returned by API
     * @return the client response
     */
    @GET
    @Path("login/ticket/{ticket}")
    String validateTicket(@PathParam("ticket") String ticket,
                          @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String authTicket,
                          @QueryParam("format") String responseFormat);

}
