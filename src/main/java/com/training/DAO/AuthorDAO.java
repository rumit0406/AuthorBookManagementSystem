package com.training.DAO;

import com.training.api.Author;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface AuthorDAO {
    int insert(Author toBeInserted, String dobString) throws SQLException;
    List<Author> findById(int id);

    List<Author> findAll();

}
