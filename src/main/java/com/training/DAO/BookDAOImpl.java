/*
package com.training.DAO;

import com.training.api.Author;
import com.training.api.Book;
import com.training.constants.SQLQueriesConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    ConnectionUtil connectionUtil;

    public BookDAOImpl(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    @Override
    public int insert(Book toBeInserted, String dopString) {
        int id = -1;
        try (Connection con = connectionUtil.getConnection()) {
            PreparedStatement statement = con.prepareStatement(SQLQueriesConstants.ADD_BOOK);
            statement.setString(1, toBeInserted.getName());
            statement.setString(2, toBeInserted.getGenre());
            statement.setInt(3, toBeInserted.getAuthorId());
            statement.setString(4, new AuthorDAOImpl(connectionUtil).findById(toBeInserted.getAuthorId()).get().getName());
//            statement.setString(4, toBeInserted.getAuthorName());
            statement.setDate(5, Date.valueOf(dopString));
            statement.setDate(6, new Date(System.currentTimeMillis()));
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
    public List<Book> findBooksByAuthorId(int authorId) {
        List<Book> bookList = new ArrayList<>();
        try (Connection con = connectionUtil.getConnection()) {
            PreparedStatement statement = con.prepareStatement(SQLQueriesConstants.READ_ALL_BOOKS_BY_AUTHORID);
            statement.setInt(1, authorId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Book book = mapRowToObject(rs);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        try (Connection con = connectionUtil.getConnection()) {
            PreparedStatement statement = con.prepareStatement(SQLQueriesConstants.READ_ALL_BOOKS);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Book book = mapRowToObject(rs);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    private Book mapRowToObject(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt(1));
        book.setName(rs.getString(2));
        book.setGenre(rs.getString(3));
        book.setAuthorId(rs.getInt(4));
        book.setAuthorName(rs.getString(5));
        book.setDateOfPublish(rs.getDate(6));
        book.setDateAdded(rs.getDate(7));
        return book;
    }
}
*/
