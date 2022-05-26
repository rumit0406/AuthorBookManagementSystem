package com.training.service_layer;

import com.training.DAO.AuthorDAO;
import com.training.DAO.AuthorDAOImpl;
import com.training.DAO.BookDAO;
import com.training.DAO.BookDAOImpl;
import com.training.api.Author;
import com.training.api.Book;

import java.util.List;
import java.util.Optional;

public class ServiceLayerImpl implements ServiceLayer {

    BookDAO bookDAO;
    AuthorDAO authorDAO;

    public ServiceLayerImpl() {
        bookDAO = new BookDAOImpl();
        authorDAO = new AuthorDAOImpl();
    }
    @Override
    public int insertAuthor(Author toBeInserted, String dobString) {
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
    public int insertBook(Book tobeAdded, String dopString) {
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
}
