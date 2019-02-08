package io.github.alirezamht.book.service;

import io.github.alirezamht.book.model.Book;

import java.util.ArrayList;

public interface BookService {

   // Book getBookById(Long id);
    ArrayList<Book> getAllBook();
    Book getBook(Long id);
    void update(Book book);
    void insert(Book book);
    void delete(Long id);
}
