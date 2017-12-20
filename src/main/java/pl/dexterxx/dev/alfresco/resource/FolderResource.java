package pl.dexterxx.dev.alfresco.resource;

import pl.dexterxx.dev.alfresco.client.Resource;
import pl.dexterxx.dev.alfresco.commons.AlfrescoConstants;
import pl.dexterxx.dev.alfresco.dto.content.FolderCreationResponse;
import pl.dexterxx.dev.alfresco.dto.content.FolderRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * FolderResource.java
 *
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface FolderResource extends Resource {

    /**
     * Creates the folder.
     *
     * @param ticket     the ticket
     * @param storeType  the store type
     * @param storeId    the store id
     * @param nodeId     the node id
     * @param folderName the folder name
     * @return the client response
     */
    @GET
    @Path("/folder/create/{store_type}/{store_id}/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String createFolder(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) final String ticket,
                        @PathParam("store_type") final String storeType, @PathParam("store_id") final String storeId, @PathParam("id") String nodeId, @QueryParam("folderName") String folderName);

    /**
     * Search folder.
     *
     * @param ticket    the ticket
     * @param storeType the store type
     * @param storeId   the store id
     * @param nodeId    the node id
     * @param query     the query
     * @return the client response
     */
    @GET
    @Path("/search/folder/{store_type}/{store_id}/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String searchFolder(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) final String ticket,
                        @PathParam("store_type") final String storeType, @PathParam("store_id") final String storeId, @PathParam("id") final String nodeId, @QueryParam("query") String query);

    /**
     * Creates the folder.
     *
     * @param ticket                the ticket
     * @param storeType             the store type
     * @param storeId               the store id
     * @param nodeId                the node id
     * @param folderCreationRequest the folder creation request
     * @return the client response
     */
    @POST
    @Path("node/folder/{storeType}/{storeId}/{nodeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    FolderCreationResponse createFolder(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
                                        @PathParam("storeType") String storeType, @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId, FolderRequest folderCreationRequest);

    /**
     * Creates the folder by cmis atom entry.
     *
     * @param ticket            the ticket
     * @param storeType         the store type
     * @param storeId           the store id
     * @param nodeId            the node id
     * @param folderCreationXml the folder creation xml
     * @return the client response
     */
    @POST
    @Path("node/{storeType}/{storeId}/{nodeId}/children")
    @Consumes("application/atom+xml;type=entry")
    @Produces(MediaType.APPLICATION_JSON)
    String createFolderByCmisAtomEntry(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
                                       @PathParam("storeType") String storeType, @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId, String folderCreationXml);

}
