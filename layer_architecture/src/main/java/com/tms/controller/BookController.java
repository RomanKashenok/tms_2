package com.tms.controller;

import com.tms.model.Book;
import com.tms.service.BookService;

public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public Book getBook(Long id) {
        return bookService.getBook(id);
    }

    public String addBook(Book book) {
        bookService.addBook(book);
        return "Book successfully added";
    }

}
