package com.tms;

import com.tms.controller.BookController;
import com.tms.model.Book;
import com.tms.repository.BookRepository;
import com.tms.repository.BookRepositoryImplMongo;
import com.tms.repository.BookRepositoryImplMysql;
import com.tms.service.BookService;
import com.tms.service.BookServiceImpl;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {

        // Контроллер -> Service -> Repository

        BookRepository br = new BookRepositoryImplMongo();

        BookService bs = new BookServiceImpl(br);

        BookController bc = new BookController(bs);

        Book b = new Book();
        b.setTitle("Harry Potter");
        b.setGenre("Fantasy");
        b.setId(847L);

        bc.addBook(b);

        Book found = bc.getBook(1L);

        System.out.println("found: " + found);

    }
}
