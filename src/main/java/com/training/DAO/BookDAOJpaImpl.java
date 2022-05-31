package com.training.DAO;

import com.training.api.Book;
import com.training.api.DateParser;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class BookDAOJpaImpl extends AbstractDAO<Book> implements BookDAO {
    public BookDAOJpaImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    public Book insert(Book toBeInserted, String dopString) {
        return persist(toBeInserted);
    }

    @Override
    public List<Book> findBooksByAuthorId(int authorId) {
        Query query = currentSession().createNamedQuery("Model.Book.findBooksByAuthorId");
        query.setParameter("authorId", authorId);
        return (List<Book>) query.getResultList();
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) namedQuery("Model.Book.findAll").list();
    }
}
