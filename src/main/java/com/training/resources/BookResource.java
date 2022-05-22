package com.training.resources;

import java.net.URI;

import com.training.api.Author;
import com.training.api.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/books")
public class BookResource {
    private List<Book> bookList;

    public BookResource() {
        super();
        bookList = new ArrayList<Book>();
        bookList.add(new Book("The Blue Umbrella", 1));
        bookList.add(new Book("The Room on the Roof", 1));
        bookList.add(new Book("Gitanjali", 2));
        bookList.add(new Book("A Study in Scarlet", 3));
        bookList.add(new Book("The Sign of Four", 3));
        bookList.add(new Book("The Hound of the Baskervilles", 3));
        bookList.add(new Book("The Valley of Fear", 3));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return bookList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{authorId}")
    public Response getBookByAuthorId(@PathParam("authorId") int authorId) {
        List<Book> booksWrittenByThisAuthor = new ArrayList<Book>();
        for (Book book : bookList) {
            if (book.getAuthorId() == authorId) {
                booksWrittenByThisAuthor.add(book);
            }
        }
        if (booksWrittenByThisAuthor.isEmpty()) {
            throw new WebApplicationException(404);
        }
        return Response.ok(booksWrittenByThisAuthor).build();
    }
}
