package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.security.Authenticated;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.jboss.logging.Logger;


@Path("/api")
@Authenticated
public class GreetingResource {
    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    int i = 0;
    private long qwe = 228;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name = "helloCals", description = "Hello call count.")
    public String hello() {
        i++;
        qwe = qwe - 1;
        return " Hello RESTEasy_" + i;
    }

    @GET
    @Path("log")
    @Produces(MediaType.TEXT_PLAIN)
    public String log() {
        LOG.info("Some useful log message");
        return " LOG RESTEasy_" + i;
    }

    @Gauge(name = "test", unit = MetricUnits.NONE, description = "228.")
    public Long test() {
        return (long) qwe;
    }
}