package com.training.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class BookAuthor implements Serializable {
    @Id
    int bookId, authorId;

    @JsonProperty
    public int getBookId() {
        return bookId;
    }

    @JsonProperty
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @JsonProperty
    public int getAuthorId() {
        return authorId;
    }

    @JsonProperty
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
