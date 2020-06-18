package com.tms.service;

import com.tms.model.Book;
import com.tms.repository.BookRepository;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public static Long currentBookId = 0L;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.getBook(id);
    }

    @Override
    public void addBook(Book book) {
        currentBookId++;
        book.setId(currentBookId);
        bookRepository.addBook(book);
    }
}
