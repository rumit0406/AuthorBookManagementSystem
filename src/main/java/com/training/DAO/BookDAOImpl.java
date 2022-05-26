package com.training.DAO;

import com.training.api.Book;
import com.training.api.DateParser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    private List<Book> bookList;

    public BookDAOImpl() {
        super();
        bookList = new ArrayList<Book>();
        bookList.add(new Book("The Blue Umbrella", "Ruskin Bond","Novel", 1));
        bookList.get(bookList.size() - 1).setId(bookList.size());
        bookList.get(bookList.size() - 1).setDateOfPublish(DateParser.parseDate("1974-01-01"));
        bookList.add(new Book("Gitanjali", "Rabindranath Tagore", "Poetry", 2));
        bookList.get(bookList.size() - 1).setId(bookList.size());
        bookList.get(bookList.size() - 1).setDateOfPublish(DateParser.parseDate("1910-01-01"));
        bookList.add(new Book("A Study in Scarlet", "Arthur Conan Doyle", "Novel", 3));
        bookList.get(bookList.size() - 1).setId(bookList.size());
        bookList.get(bookList.size() - 1).setDateOfPublish(DateParser.parseDate("1887-01-01"));
    }
    @Override
    public int insert(Book toBeInserted, String dopString) {
        toBeInserted.setId(bookList.size() + 1);
        toBeInserted.setDateOfPublish(DateParser.parseDate(dopString));
        toBeInserted.setDateAdded(new Date());
        bookList.add(toBeInserted);
        return toBeInserted.getId();
    }

    @Override
    public List<Book> findBooksByAuthorId(int authorId) {
        List<Book> res = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthorId() == authorId) {
                res.add(book);
            }
        }
        return res;
    }

    @Override
    public List<Book> findAll() {
        return bookList;
    }
}
