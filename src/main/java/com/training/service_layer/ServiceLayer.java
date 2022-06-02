package com.training.service_layer;

import com.training.api.Author;
import com.training.api.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ServiceLayer {
    Author insertAuthor(Author toBeInserted, String dobString) throws SQLException;
    Optional<Author> findAuthorByAuthorId(int authorId);
    List<Author> findAllAuthors();
    Book insertBook(Book toBeInserted, String dopString);
    List<Book> findBooksByAuthorId(int authorId);
    List<Book> findAllBooks();

    List<Author> findAuthorsOfBook(int bookId);

    Optional<Book> findBookByBookId(int id);
}
