package com.training.DAO;

import com.training.api.Author;
import com.training.api.DateParser;
import com.training.constants.SQLQueriesConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorDAOImpl implements AuthorDAO {

    ConnectionUtil connectionUtil;

    public AuthorDAOImpl(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    @Override
    public int insert(Author toBeInserted, String dobString) {
        int id = -1;
        try (Connection con = connectionUtil.getConnection()) {
            PreparedStatement statement = con.prepareStatement(SQLQueriesConstants.ADD_AUTHOR);
            statement.setString(1, toBeInserted.getName());
            statement.setString(2, toBeInserted.getNationality());
            statement.setString(3, toBeInserted.getPlaceOfBirth());
            statement.setDate(4, Date.valueOf(dobString));
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public Optional<Author> findById(int id) {
        Optional<Author> opt = Optional.empty();
        try (Connection con = connectionUtil.getConnection()) {
            PreparedStatement statement = con.prepareStatement(SQLQueriesConstants.READ_AUTHOR_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Author author = mapRowToObject(rs);
                opt = Optional.of(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return opt;
    }

    @Override
    public List<Author> findAll() {
        List<Author> authorList = new ArrayList<>();
        try (Connection con = connectionUtil.getConnection()) {
            PreparedStatement statement = con.prepareStatement(SQLQueriesConstants.READ_ALL_AUTHORS);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Author author = mapRowToObject(rs);
                authorList.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorList;
    }

    private Author mapRowToObject(ResultSet rs) {
        Author author = new Author();
        try {
            author.setId(rs.getInt(1));
            author.setName(rs.getString(2));
            author.setNationality(rs.getString(3));
            author.setPlaceOfBirth(rs.getString(4));
            author.setDateOfBirth(rs.getDate(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }
}
