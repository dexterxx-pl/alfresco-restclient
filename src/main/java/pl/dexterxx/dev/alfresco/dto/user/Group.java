package pl.dexterxx.dev.alfresco.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dexterxx.dev.alfresco.dto.BaseDto;
import pl.dexterxx.dev.alfresco.dto.common.AuthorityType;

/**
 * The Class Group.
 */
public class Group extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -1471777693101162262L;

    /**
     * The authority type.
     */
    @JsonProperty("authorityType")
    private AuthorityType authorityType;

    /**
     * The short name.
     */
    @JsonProperty("shortName")
    private String shortName;

    /**
     * The full name.
     */
    @JsonProperty("fullName")
    private String fullName;

    /**
     * The display name.
     */
    @JsonProperty("displayName")
    private String displayName;

    /**
     * The url.
     */
    @JsonProperty("url")
    private String url;

    /**
     * Gets the authority type.
     *
     * @return the authority type
     */
    public AuthorityType getAuthorityType() {
        return authorityType;
    }

    /**
     * Sets the authority type.
     *
     * @param authorityType the new authority type
     */
    public void setAuthorityType(final AuthorityType authorityType) {
        this.authorityType = authorityType;
    }

    /**
     * Gets the short name.
     *
     * @return the short name
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets the short name.
     *
     * @param shortName the new short name
     */
    public void setShortName(final String shortName) {
        this.shortName = shortName;
    }

    /**
     * Gets the full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name.
     *
     * @param fullName the new full name
     */
    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets the display name.
     *
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the display name.
     *
     * @param displayName the new display name
     */
    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     *
     * @param url the new url
     */
    public void setUrl(final String url) {
        this.url = url;
    }

}
