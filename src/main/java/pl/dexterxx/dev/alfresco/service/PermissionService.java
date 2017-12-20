package pl.dexterxx.dev.alfresco.service;

import feign.error.ErrorHandling;
import pl.dexterxx.dev.alfresco.commons.AlfrescoConstants;
import pl.dexterxx.dev.alfresco.dto.content.PermissionRequest;
import pl.dexterxx.dev.alfresco.dto.content.PermissionServiceResponse;
import pl.dexterxx.dev.alfresco.exception.PermissionException;
import pl.dexterxx.dev.alfresco.resource.PermissionResource;

/**
 * The Class PermissionService.
 */
@ErrorHandling(defaultException = PermissionException.class)
public class PermissionService extends AbstractService<PermissionResource> {

    /**
     * Instantiates a new permission service.
     *
     * @param restBaseUri the rest base uri
     * @param authTicket  the auth ticket
     */
    public PermissionService(final String restBaseUri, final String authTicket) {
        super(restBaseUri, authTicket);
    }

    /*
     * @see Service#getResourceClass()
     */
    @Override
    protected Class<PermissionResource> getResourceClass() {
        return PermissionResource.class;
    }

    /**
     * Sets the permissons.
     *
     * @param nodeProperty      the node property
     * @param storeType         the store type
     * @param storeId           the store id
     * @param nodeId            the node id
     * @param permissionRequest the permission request
     * @return the string
     * @throws PermissionException the permission exception
     */
    public String setPermissons(final String nodeProperty, final String storeType, final String storeId, final String nodeId,
                                final PermissionRequest permissionRequest) throws PermissionException {
        return resourceProxy.setPermissions(authTicket, storeType, storeId, nodeId,
                permissionRequest);
    }

    /**
     * Sets the permissons.
     *
     * @param nodeId            the node id
     * @param permissionRequest the permission request
     * @return the string
     * @throws PermissionException the permission exception
     */
    public String setPermissons(final String nodeId, final PermissionRequest permissionRequest) throws PermissionException {
        return resourceProxy.setPermissions(authTicket, AlfrescoConstants.DEFAULT_STORE_TYPE,
                AlfrescoConstants.DEFAULT_STORE_ID, nodeId, permissionRequest);
    }

    /**
     * Sets the permissions.
     * <p>
     * TODO(dexterxx) @param folderName - genesis of parameter?
     *
     * @param authorityType authority type to set
     * @param nodeId        node id on which set permission
     * @param userGroupType TODO(dexterxx) ??
     * @return the string
     * @throws PermissionException the permission exception
     */
    public PermissionServiceResponse setPermissions(final String nodeId, final String authorityType, final String userGroupType) throws PermissionException {
        return resourceProxy.setPermissions(authTicket, nodeId, authorityType, userGroupType);
    }

}
