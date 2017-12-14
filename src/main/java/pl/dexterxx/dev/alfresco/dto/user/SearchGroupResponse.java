package pl.dexterxx.dev.alfresco.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dexterxx.dev.alfresco.dto.BaseDto;

import java.util.List;

/**
 * The Class SearchGroupResponse.
 */
public class SearchGroupResponse extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 4206673779660189991L;

    /**
     * The groups.
     */
    @JsonProperty("data")
    private List<Group> groups;

    /**
     * The paging info.
     */
    @JsonProperty("paging")
    private PagingInfo pagingInfo;

    /**
     * Gets the groups.
     *
     * @return the groups
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * Sets the groups.
     *
     * @param groups the new groups
     */
    public void setGroups(final List<Group> groups) {
        this.groups = groups;
    }

    /**
     * Gets the paging info.
     *
     * @return the paging info
     */
    public PagingInfo getPagingInfo() {
        return pagingInfo;
    }

    /**
     * Sets the paging info.
     *
     * @param pagingInfo the new paging info
     */
    public void setPagingInfo(final PagingInfo pagingInfo) {
        this.pagingInfo = pagingInfo;
    }

}
