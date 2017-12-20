package pl.dexterxx.dev.alfresco.service;

import feign.error.ErrorHandling;
import pl.dexterxx.dev.alfresco.commons.AlfrescoConstants;
import pl.dexterxx.dev.alfresco.dto.content.FolderCreationResponse;
import pl.dexterxx.dev.alfresco.dto.content.FolderRequest;
import pl.dexterxx.dev.alfresco.exception.ContentException;
import pl.dexterxx.dev.alfresco.resource.FolderResource;

@ErrorHandling(defaultException = ContentException.class)
public class FolderService extends AbstractService<FolderResource> {

    /**
     * Instantiates a new folder service.
     *
     * @param restBaseUri the rest base uri
     * @param authTicket  the auth ticket
     */
    public FolderService(final String restBaseUri, final String authTicket) {
        super(restBaseUri, authTicket);
    }

    /*
     * @see Service#getResourceClass()
     */
    @Override
    protected Class<FolderResource> getResourceClass() {
        return FolderResource.class;
    }

    /**
     * this method only creates a folder,for which you need to add your custom web scripts to alfresco.
     *
     * @param nodeId     the node id
     * @param folderName the folder name
     * @return the string
     * @throws ContentException the content exception
     */
    public String createFolder(final String nodeId, final String folderName) throws ContentException {
        return resourceProxy.createFolder(authTicket,
                AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, folderName);
    }

    /**
     * this method accepts a json input where you can specify whether you want to create a folder or a new file.
     *
     * @param nodeId                the node id
     * @param folderCreationRequest the folder creation request
     * @return the string
     * @throws ContentException the content exception
     */
    public FolderCreationResponse createFolder(final String nodeId, final FolderRequest folderCreationRequest) throws ContentException {
        return resourceProxy.createFolder(authTicket,
                AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, folderCreationRequest);
    }

    /**
     * this method is now deprecated in the alfresco.. - it accepts cmis atom entry as the default input for it
     * TODO(dexterxx) @Deprecated?
     *
     * @param nodeId               the node id
     * @param fileFolderRequestXml the folder creation request
     * @return the string
     * @throws ContentException the content exception
     */
    public String createFileFolderByCmisAtomEntry(final String nodeId, final String fileFolderRequestXml) throws ContentException {
        return resourceProxy.createFolderByCmisAtomEntry(authTicket,
                AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, fileFolderRequestXml);
    }

    /**
     * Search folder.
     *
     * @param nodeId                the node id
     * @param folderSearchCmisQuery the folder search cmis query
     * @return the string
     * @throws ContentException the content exception
     */
    public String searchFolder(final String nodeId, final String folderSearchCmisQuery) throws ContentException {
        String cmisQuery = "SELECT cmis:name, cmis:objectId FROM cmis:folder WHERE cmis:parentId='" + nodeId + "' AND ";
        cmisQuery += folderSearchCmisQuery;
        return resourceProxy.searchFolder(authTicket,
                AlfrescoConstants.DEFAULT_STORE_TYPE, AlfrescoConstants.DEFAULT_STORE_ID, nodeId, cmisQuery);
    }
}
