package com.training.resources;

import java.net.URI;
import com.training.api.Author;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/authors")
public class AuthorResource {
    private ArrayList<Author> authorList;

    public AuthorResource() {
        super();
        authorList = new ArrayList<Author>();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAuthors() {
        return "hello world";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAuthor(Author toBeAdded) {
        authorList.add(toBeAdded);
        return Response.created(URI.create("/products/" + toBeAdded.getId())).entity(toBeAdded).build();
    }
}
