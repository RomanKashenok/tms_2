package com.tms.repository;

import com.tms.model.Book;

import java.sql.*;

public class BookRepositoryImplMysql implements BookRepository {

    private Connection con;

    public BookRepositoryImplMysql() throws SQLException {
        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledb", "root", "password");
    }

    @Override
    public Book getBook(Long id) {
        Book book = null;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE id = ?");
            ps.setLong(1, id);
            book = createBook(ps.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public void addBook(Book book) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO books (id, genre, title) VALUES (?, ?, ?)");
            ps.setLong(1, book.getId());
            ps.setString(2, book.getGenre());
            ps.setString(3, book.getTitle());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Book createBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        while(rs.next()) {
            book.setId(rs.getLong("id"));
            book.setTitle(rs.getString("title"));
            book.setGenre(rs.getString("genre"));
        }
        return book;
    }
}
