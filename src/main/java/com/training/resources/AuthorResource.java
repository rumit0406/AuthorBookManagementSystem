package com.training.resources;

import java.net.URI;

import com.training.api.Author;
import com.training.service_layer.ServiceLayer;
import com.training.service_layer.ServiceLayerImpl;
import io.dropwizard.hibernate.UnitOfWork;

import javax.transaction.Transactional;
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
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAuthors() {
        return serviceLayer.findAllAuthors();
    }

    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAuthor(Author toBeAdded,
                              @HeaderParam("dobString") String dobString) throws SQLException {
        int id = serviceLayer.insertAuthor(toBeAdded, dobString);
        return Response.created(URI.create("/authors/" + id)).build();
    }

    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") int id) {
        List<Author> list = serviceLayer.findAuthorByAuthorId(id);
        return Response.ok(list).build();
    }
}
