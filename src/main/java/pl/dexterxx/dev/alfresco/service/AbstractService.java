package pl.dexterxx.dev.alfresco.service;

import pl.dexterxx.dev.alfresco.client.Resource;
import pl.dexterxx.dev.alfresco.client.Service;

/**
 * The Class AbstractService.
 *
 * @param <R> the generic type
 */
public abstract class AbstractService<R extends Resource> extends Service<R> {

    /**
     * The auth ticket.
     */
    protected final String authTicket;

    /**
     * Instantiates a new abstract service.
     *
     * @param restBaseUri the rest base uri
     * @param authTicket  the auth ticket
     */
    public AbstractService(final String restBaseUri, final String authTicket) {
        super(restBaseUri);
        this.authTicket = authTicket;
    }

}
