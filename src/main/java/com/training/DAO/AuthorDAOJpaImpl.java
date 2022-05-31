package com.training.DAO;

import com.training.api.Author;
import com.training.api.DateParser;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.UnitOfWork;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

import com.training.constants.SQLQueriesConstants;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;


public class AuthorDAOJpaImpl extends AbstractDAO<Author> implements AuthorDAO {
    EntityManager em;

    public AuthorDAOJpaImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    public int insert(Author toBeInserted, String dobString) {
        toBeInserted.setDateOfBirth(DateParser.parseDate(dobString));
        return persist(toBeInserted).getId();
    }

//    @Override
//    public Optional<Author> findById(int id) {
//        Author author = get(id);
//        return author == null ? Optional.empty() : Optional.of(author);
//    }

    @Override
    public List<Author> findById(int id) {
        return (List<Author>) namedQuery("Model.Author.findById").setParameter("id", id).list();
    }

    @Override
    public List<Author> findAll() {
        return (List<Author>) namedQuery("Model.Author.findAll").list();
    }
}
