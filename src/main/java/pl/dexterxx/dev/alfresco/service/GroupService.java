package pl.dexterxx.dev.alfresco.service;

import feign.error.ErrorHandling;
import pl.dexterxx.dev.alfresco.dto.user.AuthorityQuery;
import pl.dexterxx.dev.alfresco.dto.user.Group;
import pl.dexterxx.dev.alfresco.dto.user.GroupQuery;
import pl.dexterxx.dev.alfresco.dto.user.SearchGroupResponse;
import pl.dexterxx.dev.alfresco.exception.GroupException;
import pl.dexterxx.dev.alfresco.resource.GroupResource;

/**
 * The Class GroupService.
 */
@ErrorHandling(defaultException = GroupException.class)
public class GroupService extends AbstractService<GroupResource> {

    /**
     * Instantiates a new group service.
     *
     * @param restBaseUri the rest base uri
     * @param authTicket  the auth ticket
     */
    public GroupService(final String restBaseUri, final String authTicket) {
        super(restBaseUri, authTicket);
    }

    /*
     * @see Service#getResourceClass()
     */
    @Override
    protected Class<GroupResource> getResourceClass() {
        return GroupResource.class;
    }

    /**
     * Gets the groups.
     *
     * @param groupQuery the group query
     * @return the groups
     * @throws GroupException the group exception
     */
    public SearchGroupResponse getGroups(final GroupQuery groupQuery)
            throws GroupException {
        return resourceProxy.getGroups(authTicket, groupQuery);
    }

    /**
     * Gets the group.
     *
     * @param groupShortName the group short name
     * @return the group
     * @throws GroupException the group exception
     */
    public Group getGroup(final String groupShortName) throws GroupException {
        return resourceProxy.getGroup(authTicket, groupShortName).get("data");
    }

    /**
     * Gets the root groups.
     *
     * @param groupQuery the group query
     * @return the root groups
     * @throws GroupException the group exception
     */
    public SearchGroupResponse getRootGroups(final GroupQuery groupQuery)
            throws GroupException {
        return resourceProxy.getRootGroups(authTicket, groupQuery);
    }

    /**
     * Gets the child authorities.
     *
     * @param groupShortName the group short name
     * @param authorityQuery the authority query
     * @return the child authorities
     * @throws GroupException the group exception
     */
    public SearchGroupResponse getChildAuthorities(final String groupShortName,
                                                   final AuthorityQuery authorityQuery) throws GroupException {
        return resourceProxy.getChildAuthorities(authTicket, groupShortName, authorityQuery);
    }

    /**
     * Gets the parent authorities.
     *
     * @param groupShortName the group short name
     * @param authorityQuery the authority query
     * @return the parent authorities
     * @throws GroupException the group exception
     */
    public SearchGroupResponse getParentAuthorities(final String groupShortName,
                                                    final AuthorityQuery authorityQuery) throws GroupException {
        return resourceProxy.getParentAuthorities(authTicket, groupShortName, authorityQuery);
    }

    /**
     * Delete group.
     *
     * @param groupShortName the group short name
     * @throws GroupException the group exception
     */
    public void deleteGroup(final String groupShortName) throws GroupException {
        resourceProxy.deleteGroup(authTicket, groupShortName);
    }
}
