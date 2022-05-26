package com.training.DAO;

import com.training.api.Author;
import com.training.api.DateParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorDAOImpl implements AuthorDAO {

    private List<Author> authorList;
    public AuthorDAOImpl() {
        super();
        authorList = new ArrayList<>();
        authorList.add(new Author(1, "Ruskin Bond", "Indian", "Kasauli",
                DateParser.parseDate("1934-05-19")));
        authorList.add(new Author(2, "Rabindranath Tagore", "Indian", "Calcutta",
                DateParser.parseDate("1861-05-07")));
        authorList.add(new Author(3, "Arthur Conan Doyle", "British", "Scotland",
                DateParser.parseDate("1859-05-22")));
    }

    @Override
    public int insert(Author toBeInserted, String dobString) {
        toBeInserted.setId(getIdNewAuthor());
        toBeInserted.setDateOfBirth(DateParser.parseDate(dobString));
        authorList.add(toBeInserted);
        return toBeInserted.getId();
    }

    @Override
    public int getIdNewAuthor() {
        return 1 + authorList.size();
    }
    @Override
    public Optional<Author> findById(int id) {
        Optional<Author> opt = Optional.empty();
        for (Author author : authorList) {
            if (author.getId() == id) {
                opt = Optional.of(author);
                break;
            }
        }
        return opt;
    }

    @Override
    public List<Author> findAll() {
        return authorList;
    }
}
