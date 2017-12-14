package pl.dexterxx.dev.alfresco.resource;

import feign.Param;
import pl.dexterxx.dev.alfresco.client.Resource;
import pl.dexterxx.dev.alfresco.commons.AlfrescoConstants;
import pl.dexterxx.dev.alfresco.dto.user.AuthorityQuery;
import pl.dexterxx.dev.alfresco.dto.user.Group;
import pl.dexterxx.dev.alfresco.dto.user.GroupQuery;
import pl.dexterxx.dev.alfresco.dto.user.SearchGroupResponse;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * The Interface GroupResource.
 */
@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface GroupResource extends Resource {

    /**
     * Gets the groups.
     *
     * @param ticket     the ticket
     * @param groupQuery the group query
     * @return the groups
     * TODO(dexterxx) before was @Form GroupQuery groupQuery
     */
    @GET
    @Path("groups")
    @Produces(MediaType.APPLICATION_JSON)
    SearchGroupResponse getGroups(
            @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @Param("form") GroupQuery groupQuery);

    /**
     * Gets the group.
     *
     * @param ticket    the ticket
     * @param shortName the short name
     * @return the group
     */
    @GET
    @Path("groups/{shortName}")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Group> getGroup(
            @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @PathParam("shortName") String shortName);

    /**
     * Gets the root groups.
     *
     * @param ticket     the ticket
     * @param groupQuery the group query
     * @return the root groups
     * TODO(dexterxx) before was @Form GroupQuery groupQuery
     */
    @GET
    @Path("rootgroups")
    @Produces(MediaType.APPLICATION_JSON)
    SearchGroupResponse getRootGroups(
            @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @Param("form") GroupQuery groupQuery);

    /**
     * Gets the child authorities.
     *
     * @param ticket         the ticket
     * @param shortName      the short name
     * @param authorityQuery the authority query
     * @return the child authorities
     * TODO(dexterxx) before was @Form AuthorityQuery authorityQuery
     */
    @GET
    @Path("groups/{shortName}/children")
    @Produces(MediaType.APPLICATION_JSON)
    SearchGroupResponse getChildAuthorities(
            @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @PathParam("shortName") String shortName,
            @Param("form") AuthorityQuery authorityQuery);

    /**
     * Gets the parent authorities.
     *
     * @param ticket         the ticket
     * @param shortName      the short name
     * @param authorityQuery the authority query
     * @return the parent authorities
     * TODO(dexterxx) before was @Form AuthorityQuery authorityQuery
     */
    @GET
    @Path("groups/{shortName}/parents")
    @Produces(MediaType.APPLICATION_JSON)
    SearchGroupResponse getParentAuthorities(
            @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @PathParam("shortName") String shortName,
            @Param("form") AuthorityQuery authorityQuery);

    /**
     * Delete group.
     *
     * @param ticket    the ticket
     * @param shortName the short name
     * @return the client response
     */
    @DELETE
    @Path("groups/{shortName}")
    @Produces(MediaType.APPLICATION_JSON)
    String deleteGroup(
            @QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
            @PathParam("shortName") String shortName);

}
