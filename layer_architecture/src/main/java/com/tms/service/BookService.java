package com.tms.service;

import com.tms.model.Book;

public interface BookService {

    Book getBook(Long id);
    void addBook(Book book);
}
