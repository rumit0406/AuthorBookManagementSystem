package com.training.resources;

import java.net.URI;

import com.training.api.Author;
import com.training.api.Book;
import com.training.service_layer.ServiceLayer;
import io.dropwizard.hibernate.UnitOfWork;

import com.google.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/authors")

public class AuthorResource {
    @Inject
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
        Author author = serviceLayer.insertAuthor(toBeAdded, dobString);
        return Response.created(URI.create("/authors/" + author.getId())).entity(author).build();
    }

    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") int id) {
        Optional<Author> opt = serviceLayer.findAuthorByAuthorId(id);
        if (!opt.isPresent()) {
            throw new WebApplicationException(404);
        }
        return Response.ok(opt.get()).build();
    }

    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{authorId}/books")
    public Response getBookByAuthorId(@PathParam("authorId") int authorId) {
        List<Book> booksWrittenByThisAuthor = serviceLayer.findBooksByAuthorId(authorId);
        return Response.ok(booksWrittenByThisAuthor).build();
    }
}
