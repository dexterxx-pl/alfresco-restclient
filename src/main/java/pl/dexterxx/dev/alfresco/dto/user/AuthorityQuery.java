package pl.dexterxx.dev.alfresco.dto.user;

import pl.dexterxx.dev.alfresco.dto.common.AuthorityType;

import javax.ws.rs.QueryParam;

/**
 * The Class AuthorityQuery.
 */
public class AuthorityQuery extends BaseQuery {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -3979600916433012399L;

    /**
     * The authority type.
     */
    @QueryParam("authorityType")
    private AuthorityType authorityType;

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

}
