package pl.dexterxx.dev.alfresco.resource;

import pl.dexterxx.dev.alfresco.client.Resource;
import pl.dexterxx.dev.alfresco.commons.AlfrescoConstants;
import pl.dexterxx.dev.alfresco.dto.content.PermissionRequest;
import pl.dexterxx.dev.alfresco.dto.content.PermissionServiceResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * The Interface PermissionResource.
 */
// @Path("/alfresco/service/slingshot/doclib/")
@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface PermissionResource extends Resource {

    /**
     * Sets the permissions.
     *
     * @param ticket            the ticket
     * @param storeType         the store type
     * @param storeId           the store id
     * @param nodeId            the node id
     * @param permissionRequest the permission request
     * @return the client response
     */
    @POST
    @Path("permissions/{storeType}/{storeId}/{nodeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String setPermissions(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
                          @PathParam("storeType") String storeType, @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId,
                          PermissionRequest permissionRequest);

    @GET
    @Path("/alfresco/service/permissions/{store_type}/{store_id}/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String readPermissions(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
                           @PathParam("store_type") String storeType, @PathParam("store_id") String storeId, @PathParam("id") String nodeId);

    @GET
    @Path("/set/folder/permission")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    PermissionServiceResponse setPermissions(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket, @QueryParam("nodeId") String nodeId,
                                             @QueryParam("authorityType") final String authorityType,
                                             @QueryParam("userGroupType") final String userGroupType);

}
