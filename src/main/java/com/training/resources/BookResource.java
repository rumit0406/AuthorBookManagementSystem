package com.training.resources;

import com.training.api.Book;
import com.training.api.DateParser;
import com.training.service_layer.ServiceLayer;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Date;
import java.util.List;

@Path("/books")
public class BookResource {
    private ServiceLayer serviceLayer;

    public BookResource(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return serviceLayer.findAllBooks();
    }

    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBook(@HeaderParam("dopString") String dopString, Book tobeAdded) {
        //does this violate SOLID??
        tobeAdded.setDateOfPublish(DateParser.parseDate(dopString));
        tobeAdded.setDateAdded(new Date());
        tobeAdded.setAuthorName(serviceLayer.findAuthorByAuthorId(tobeAdded.getAuthorId()).get().getName());
        tobeAdded = serviceLayer.insertBook(tobeAdded, dopString);
        return Response.created(URI.create("books/" + tobeAdded.getId())).entity(tobeAdded).build();
    }

    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{authorId}")
    public Response getBookByAuthorId(@PathParam("authorId") int authorId) {
        List<Book> booksWrittenByThisAuthor = serviceLayer.findBooksByAuthorId(authorId);
        return Response.ok(booksWrittenByThisAuthor).build();
    }
}
