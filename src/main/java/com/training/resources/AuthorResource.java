package com.training.resources;

import java.net.URI;
import com.training.api.Author;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/authors")
public class AuthorResource {
    private List<Author> authorList;

    public AuthorResource() {
        super();
        authorList = new ArrayList<Author>();
        authorList.add(new Author(1, "Ruskin Bond"));
        authorList.add(new Author(2, "Rabindranath Tagore"));
        authorList.add(new Author(3, "Arthur Conan Doyle"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAuthors() {
        return authorList;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAuthor(Author toBeAdded) {
        authorList.add(toBeAdded);
        return Response.created(URI.create("/products/" + toBeAdded.getId())).entity(toBeAdded).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") int id) {
        for (Author author : authorList) {
            if (author.getId() == id) {
                return Response.ok(author).build();
            }
        }
        throw new WebApplicationException(404);
    }
}
