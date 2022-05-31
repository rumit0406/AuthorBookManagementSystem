package com.training.service_layer;

import com.training.api.Author;
import com.training.api.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ServiceLayer {
    int insertAuthor(Author toBeInserted, String dobString) throws SQLException;
    List<Author> findAuthorByAuthorId(int authorId);
    List<Author> findAllAuthors();
    int insertBook(Book toBeInserted, String dopString);
    List<Book> findBooksByAuthorId(int authorId);
    List<Book> findAllBooks();
}
