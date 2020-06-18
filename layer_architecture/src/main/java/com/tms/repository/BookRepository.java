package com.tms.repository;

import com.tms.model.Book;

public interface BookRepository {

    Book getBook(Long id);
    void addBook(Book book);

}
