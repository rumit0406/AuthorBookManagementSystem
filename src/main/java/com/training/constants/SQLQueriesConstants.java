package com.training.constants;

public class SQLQueriesConstants {
    public static final String ADD_AUTHOR = "insert into author (name, nationality, placeOfBirth, dateOfBirth) values (?,?,?,?)";
    public static final String READ_ALL_AUTHORS = "select * from author";
    public static final String READ_AUTHOR_BY_ID = "select * from author where id = ?";
    public static final String READ_ALL_BOOKS = "select * from book";
    public static final String READ_ALL_BOOKS_BY_AUTHORID = "select * from book where authorId = ?";
    public static final String ADD_BOOK = "insert into book (name,genre,authorId,authorName,dateOfPublish, dateAdded) values (?, ?, ?, ?, ?, ?)";
}
