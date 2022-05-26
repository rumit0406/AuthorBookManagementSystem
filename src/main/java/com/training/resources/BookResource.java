package com.training.resources;

import com.training.api.Book;
import com.training.service_layer.ServiceLayer;
import com.training.service_layer.ServiceLayerImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/books")
public class BookResource {
    private ServiceLayer serviceLayer;

    public BookResource() {
        super();
        serviceLayer = new ServiceLayerImpl();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return serviceLayer.findAllBooks();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBook(@HeaderParam("dopString") String dopString, Book tobeAdded) {
        //Possible Feature: don't take authorid only take authornames and assign authorid by yourself
        //Possible Feature: Add new author when the given author name isn't in the database
        int id = serviceLayer.insertBook(tobeAdded, dopString);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{authorId}")
    public Response getBookByAuthorId(@PathParam("authorId") int authorId) {
        List<Book> booksWrittenByThisAuthor = serviceLayer.findBooksByAuthorId(authorId);
        return Response.ok(booksWrittenByThisAuthor).build();
    }
}
