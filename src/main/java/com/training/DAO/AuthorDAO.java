package com.training.DAO;

import com.training.api.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDAO {
    int insert(Author toBeInserted, String dobString);
    Optional<Author> findById(int id);
    List<Author> findAll();

    int getIdNewAuthor();
}
