package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.micrometer.core.instrument.MeterRegistry;
import io.quarkus.security.Authenticated;
import org.jboss.logging.Logger;



@Path("/api")
@Authenticated
public class GreetingResource {
    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    int i = 0;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        i++;
        return " Hello RESTEasy_" + i;
    }

    @GET
    @Path("log")
    @Produces(MediaType.TEXT_PLAIN)
    public String log() {
        LOG.info("Some useful log message");
        return " LOG RESTEasy_" + i;
    }
}