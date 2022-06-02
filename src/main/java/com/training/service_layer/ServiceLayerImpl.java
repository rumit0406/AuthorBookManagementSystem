package com.training.service_layer;

import com.training.DAO.AuthorDAO;
import com.training.DAO.BookDAO;
import com.training.api.Author;
import com.training.api.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ServiceLayerImpl implements ServiceLayer {

    AuthorDAO authorDAO;
    BookDAO bookDAO;

    public ServiceLayerImpl(AuthorDAO authorDAO, BookDAO bookDAO) {
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
    }

    @Override
    public Author insertAuthor(Author toBeInserted, String dobString) throws SQLException {
        return authorDAO.insert(toBeInserted, dobString);
    }

    @Override
    public Optional<Author> findAuthorByAuthorId(int authorId) {
        return authorDAO.findById(authorId);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorDAO.findAll();
    }

    @Override
    public Book insertBook(Book tobeAdded, String dopString) {
        return bookDAO.insert(tobeAdded, dopString);
    }

    @Override
    public List<Book> findBooksByAuthorId(int authorId) {
        return bookDAO.findBooksByAuthorId(authorId);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookDAO.findAll();
    }

    @Override
    public List<Author> findAuthorsOfBook(int bookId) {
        return authorDAO.findAuthorsOfBook(bookId);
    }

    @Override
    public Optional<Book> findBookByBookId(int id) {
        return bookDAO.findBookByBookId(id);
    }
}
