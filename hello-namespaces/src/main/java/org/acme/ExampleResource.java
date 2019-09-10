package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Path("/hello")
public class ExampleResource {

    private ArrayList<String> guyz = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return String.format("Hello %s", String.join(",", guyz));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{name}")
    public String stackHello(@PathParam("name") String name) {
        guyz.add(name);
        return hello();
    }
}