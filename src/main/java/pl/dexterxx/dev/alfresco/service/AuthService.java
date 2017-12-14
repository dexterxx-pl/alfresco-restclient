package pl.dexterxx.dev.alfresco.service;

import feign.error.ErrorHandling;
import pl.dexterxx.dev.alfresco.client.Service;
import pl.dexterxx.dev.alfresco.dto.AuthResponse;
import pl.dexterxx.dev.alfresco.dto.Credentials;
import pl.dexterxx.dev.alfresco.dto.error.ServiceResponse;
import pl.dexterxx.dev.alfresco.exception.AuthenticationException;
import pl.dexterxx.dev.alfresco.resource.AuthResource;

/**
 * The Class AuthService.
 */
@ErrorHandling(defaultException = AuthenticationException.class)
public class AuthService extends Service<AuthResource> {

    /**
     * The credentials.
     */
    protected final Credentials credentials;

    /**
     * Instantiates a new auth service.
     *
     * @param restBaseUri the rest base uri
     * @param credentials the credentials
     */
    public AuthService(final String restBaseUri, final Credentials credentials) {
        super(restBaseUri);
        this.credentials = credentials;
    }

    /**
     * Instantiates a new auth service.
     *
     * @param restBaseUri the rest base uri
     */
    public AuthService(final String restBaseUri) {
        super(restBaseUri);
        this.credentials = null;
    }

    /*
     * @see Service#getResourceClass()
     */
    @Override
    protected Class<AuthResource> getResourceClass() {
        return AuthResource.class;
    }

    /**
     * Login.
     *
     * @return the auth response
     * @throws AuthenticationException the authentication exception
     */
    public AuthResponse login() throws AuthenticationException {
        return resourceProxy.login(credentials);
    }

    /**
     * Logout.
     *
     * @param authTicket the auth ticket
     * @return the service response
     * @throws AuthenticationException the authentication exception
     */
    public ServiceResponse logout(final String authTicket) throws AuthenticationException {
        return resourceProxy.logout(authTicket, authTicket, "json");
    }

    /**
     * Validate ticket.
     *
     * @param authTicket the auth ticket
     * @return the service response
     * @throws AuthenticationException the authentication exception
     */
    public String validateTicket(final String authTicket) throws AuthenticationException {
        return resourceProxy.validateTicket(authTicket, authTicket, "xml");
    }

}
