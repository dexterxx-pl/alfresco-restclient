package pl.dexterxx.dev.alfresco.service;

import feign.error.ErrorHandling;
import pl.dexterxx.dev.alfresco.commons.AlfrescoConstants;
import pl.dexterxx.dev.alfresco.dto.content.ContentMetadata;
import pl.dexterxx.dev.alfresco.dto.content.ContentNode;
import pl.dexterxx.dev.alfresco.dto.content.ContentUploadForm;
import pl.dexterxx.dev.alfresco.dto.content.DocumentContent;
import pl.dexterxx.dev.alfresco.dto.content.NodeUpdateStatus;
import pl.dexterxx.dev.alfresco.dto.content.SearchRequest;
import pl.dexterxx.dev.alfresco.dto.content.UploadResponse;
import pl.dexterxx.dev.alfresco.exception.ContentException;
import pl.dexterxx.dev.alfresco.exception.SearchException;
import pl.dexterxx.dev.alfresco.resource.ContentResource;

import java.util.List;

/**
 * The Class ContentService.
 */
@ErrorHandling(defaultException = ContentException.class)
public class ContentService extends AbstractService<ContentResource> {

    /**
     * Instantiates a new content service.
     *
     * @param restBaseUri the rest base uri
     * @param authTicket  the auth ticket
     */
    public ContentService(final String restBaseUri, final String authTicket) {
        super(restBaseUri, authTicket);
    }

    /*
     * @see Service#getResourceClass()
     */
    @Override
    protected Class<ContentResource> getResourceClass() {
        return ContentResource.class;
    }

    /**
     * Gets the node content.
     *
     * @param nodeProperty the node property
     * @param storeType    the store type
     * @param storeId      the store id
     * @param nodeId       the node id
     * @return the node content
     * @throws ContentException the content exception
     */
    public DocumentContent getNodeContent(final String nodeProperty, final String storeType, final String storeId, final String nodeId)
            throws ContentException {
        return resourceProxy.getNodeContent(authTicket, nodeProperty, storeType,
                storeId, nodeId, true);
    }

    /**
     * Gets the node content.
     *
     * @param storeType the store type
     * @param storeId   the store id
     * @param nodeId    the node id
     * @return the node content
     * @throws ContentException the content exception
     */
    public DocumentContent getNodeContent(final String storeType, final String storeId, final String nodeId) throws ContentException {
        return resourceProxy.getNodeContent(authTicket, "", storeType, storeId,
                nodeId, true);
    }

    /**
     * Gets the node content.
     *
     * @param nodeId the node id
     * @return the node content
     * @throws ContentException the content exception
     */
    public DocumentContent getNodeContent(final String nodeId) throws ContentException {
        return resourceProxy.getNodeContent(authTicket, "",
                AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, true);
    }

    /**
     * Upload document.
     *
     * @param uploadMetadata the upload metadata
     * @return the upload response
     * @throws ContentException the content exception
     */
    public UploadResponse uploadDocument(final ContentUploadForm uploadMetadata) throws ContentException {
        return resourceProxy.uploadDocument(authTicket, uploadMetadata);
    }

    /**
     * Search.
     *
     * @param searchReuqest the search reuqest
     * @return the list
     * @throws SearchException the search exception
     */
    @ErrorHandling(defaultException = SearchException.class)
    public List<ContentNode> search(final SearchRequest searchReuqest) throws SearchException {
        return resourceProxy.advancedSearch(authTicket, searchReuqest);
    }

    /**
     * Store node metadata.
     *
     * @param storeType       the store type
     * @param storeId         the store id
     * @param nodeId          the node id
     * @param contentMetadata the content metadata
     * @return the node update status
     * @throws ContentException the content exception
     */
    public NodeUpdateStatus storeNodeMetadata(final String storeType, final String storeId, final String nodeId, final ContentMetadata contentMetadata)
            throws ContentException {
        return resourceProxy.storeNodeMetadata(authTicket, storeType, storeId, nodeId,
                contentMetadata);
    }

    /**
     * Store node metadata.
     *
     * @param nodeId          the node id
     * @param contentMetadata the content metadata
     * @return the node update status
     * @throws ContentException the content exception
     */
    public NodeUpdateStatus storeNodeMetadata(final String nodeId, final ContentMetadata contentMetadata) throws ContentException {
        return resourceProxy.storeNodeMetadata(authTicket,
                AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, contentMetadata);
    }

    /**
     * Delete document.
     *
     * @param nodeId          the node id
     * @param includeChildren the include children
     * @return the string
     * @throws ContentException the content exception
     */
    public String deleteDocument(final String nodeId, final boolean includeChildren) throws ContentException {
        return resourceProxy.deleteDocument(authTicket,
                AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, includeChildren);
    }

}
