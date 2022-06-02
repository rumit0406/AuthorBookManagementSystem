package com.training.DAO;

import com.training.api.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    Book insert(Book toBeInserted, String dopString);
    List<Book> findBooksByAuthorId(int authorId);
    List<Book> findAll();

    Optional<Book> findBookByBookId(int id);
}
