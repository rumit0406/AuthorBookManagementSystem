package com.training.DAO;

import com.training.api.Book;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDAOJpaImpl extends AbstractDAO<Book> implements BookDAO{
    public BookDAOJpaImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    public int insert(Book toBeInserted, String dopString) {
        return 0;
    }

    @Override
    public List<Book> findBooksByAuthorId(int authorId) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }
}
