package de.weltraumschaf.nas.ui.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 */
@Path("/nas")
public final class NasResource {

    @GET
    public Response index() {
        return Response.ok().entity( "Yes, it works." ).build();
    }
}
