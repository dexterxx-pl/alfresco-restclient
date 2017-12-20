package pl.dexterxx.dev.alfresco.dto.user;

import javax.ws.rs.QueryParam;

/**
 * The Class GroupQuery.
 */
public class GroupQuery extends BaseQuery {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 4809842369740131482L;

    /**
     * The short name filter.
     */
    @QueryParam("shortNameFilter")
    private String shortNameFilter;

    /**
     * The zone.
     */
    @QueryParam("zone")
    private Boolean zone;

    /**
     * Gets the short name filter.
     *
     * @return the short name filter
     */
    public String getShortNameFilter() {
        return shortNameFilter;
    }

    /**
     * Sets the short name filter.
     *
     * @param shortNameFilter the new short name filter
     */
    public void setShortNameFilter(final String shortNameFilter) {
        this.shortNameFilter = shortNameFilter;
    }

    /**
     * Gets the zone.
     *
     * @return the zone
     */
    public Boolean getZone() {
        return zone;
    }

    /**
     * Sets the zone.
     *
     * @param zone the new zone
     */
    public void setZone(final Boolean zone) {
        this.zone = zone;
    }

}
