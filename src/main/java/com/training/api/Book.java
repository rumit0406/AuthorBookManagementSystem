package com.training.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.units.qual.N;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Model.Book.findAll", query = "select b from Book b"),
        @NamedQuery(name = "Model.Book.findBooksByAuthorId", query = "select b from Book b, BookAuthor ba where ba.authorId = :authorId and b.id = ba.bookId")
})
//select b from Book b, BookAuthor ba where ba.authorId = :authorId and b.id = ba.bookId
//select b from Book b join BookAuthor ab on b.id = BookAuthor.bookId
public class Book {
    private String name, genre;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateOfPublish, dateAdded;

    public Book(String name, String genre) {
        this.name = name;
        this.genre = genre;
//        this.dateOfPublish = dateOfPublish;
        this.dateAdded = new Date();
    }

    public Book() {
    }

    @JsonProperty
    public String getName() {
        return name;
    }
    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty
    public String getGenre() {
        return genre;
    }
    @JsonProperty
    public void setGenre(String genre) {
        this.genre = genre;
    }
    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public void setId(int id) {
        this.id = id;
    }
    @JsonProperty
    public Date getDateOfPublish() {
        return dateOfPublish;
    }
    @JsonProperty
    public void setDateOfPublish(Date dateOfPublish) {
        this.dateOfPublish = dateOfPublish;
    }
    @JsonProperty
    public Date getDateAdded() {
        return dateAdded;
    }
    @JsonProperty
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
