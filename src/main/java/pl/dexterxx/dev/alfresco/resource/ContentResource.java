package pl.dexterxx.dev.alfresco.resource;

import feign.Param;
import pl.dexterxx.dev.alfresco.client.Resource;
import pl.dexterxx.dev.alfresco.commons.AlfrescoConstants;
import pl.dexterxx.dev.alfresco.dto.content.ContentMetadata;
import pl.dexterxx.dev.alfresco.dto.content.ContentNode;
import pl.dexterxx.dev.alfresco.dto.content.ContentUploadForm;
import pl.dexterxx.dev.alfresco.dto.content.DocumentContent;
import pl.dexterxx.dev.alfresco.dto.content.NodeUpdateStatus;
import pl.dexterxx.dev.alfresco.dto.content.SearchRequest;
import pl.dexterxx.dev.alfresco.dto.content.UploadResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * The Interface ContentResource.
 */
@Path(AlfrescoConstants.RESOURCE_CONTEXT_BASE_PATH)
public interface ContentResource extends Resource {

    /**
     * Gets the node content.
     *
     * @param ticket       the ticket
     * @param nodeProperty the node property
     * @param storeType    the store type
     * @param storeId      the store id
     * @param nodeId       the node id
     * @param attach       the attach
     * @return the node content
     */
    @GET
    @Path("node/content{nodeProperty}/{storeType}/{storeId}/{nodeId}")
    DocumentContent getNodeContent(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
                                   @PathParam("nodeProperty") String nodeProperty, @PathParam("storeType") String storeType,
                                   @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId, @QueryParam("a") boolean attach);

    /**
     * Upload document.
     *
     * @param ticket                the ticket
     * @param contentUploadMetadata the content upload metadata
     * @return the client response
     * TODO(dexterxx) before was @MultipartForm ContentUploadForm contentUploadMetadata
     */
    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    UploadResponse uploadDocument(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
                                  @Param("form") ContentUploadForm contentUploadMetadata);

    /**
     * Gets the node metadata.
     *
     * @param ticket the ticket
     * @param nodeId the node id
     * @return the node metadata
     */
    @GET
    @Path("metadata")
    DocumentContent getNodeMetadata(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
                                    @PathParam("nodeId") String nodeId);

    /**
     * Store node metadata.
     *
     * @param ticket          the ticket
     * @param storeType       the store type
     * @param storeId         the store id
     * @param nodeId          the node id
     * @param contentMetadata the content metadata
     * @return the client response
     */
    @POST
    @Path("metadata/node/{storeType}/{storeId}/{nodeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    NodeUpdateStatus storeNodeMetadata(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
                                       @PathParam("storeType") String storeType, @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId,
                                       ContentMetadata contentMetadata);

    /**
     * Advanced search.
     *
     * @param ticket        the ticket
     * @param searchReuqest the search reuqest
     * @return the client response
     */
    @POST
    @Path("search/advanced")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<ContentNode> advancedSearch(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
                                     SearchRequest searchReuqest);

    /**
     * Delete document.
     *
     * @param ticket            the ticket
     * @param storeType         the store type
     * @param storeId           the store id
     * @param nodeId            the node id
     * @param includeChildNodes the include child nodes
     * @return the client response
     */
    @DELETE
    @Path("node/{storeType}/{storeId}/{nodeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String deleteDocument(@QueryParam(AlfrescoConstants.AUTH_TICKET_PARAM_NAME) String ticket,
                          @PathParam("storeType") String storeType, @PathParam("storeId") String storeId, @PathParam("nodeId") String nodeId,
                          @QueryParam("includeChildren") boolean includeChildNodes);

}
