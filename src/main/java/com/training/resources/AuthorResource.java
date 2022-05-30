package com.training.resources;

import java.net.URI;

import com.training.api.Author;
import com.training.service_layer.ServiceLayer;
import com.training.service_layer.ServiceLayerImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/authors")
public class AuthorResource {
    ServiceLayer serviceLayer;

    public AuthorResource(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAuthors() {
        return serviceLayer.findAllAuthors();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAuthor(Author toBeAdded,
                              @HeaderParam("dobString") String dobString) throws SQLException {
        int id = serviceLayer.insertAuthor(toBeAdded, dobString);
        return Response.created(URI.create("/authors/" + id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") int id) {
        Optional<Author> opt = serviceLayer.findAuthorByAuthorId(id);
        if (opt.isEmpty()) {
            throw new WebApplicationException(404);
        }
        return Response.ok(opt.get()).build();
    }
}
