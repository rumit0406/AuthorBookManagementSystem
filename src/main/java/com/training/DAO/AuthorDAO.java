package com.training.DAO;

import com.training.api.Author;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface AuthorDAO {
    Author insert(Author toBeInserted, String dobString) throws SQLException;
    Optional<Author> findById(int id);

    List<Author> findAll();

}
