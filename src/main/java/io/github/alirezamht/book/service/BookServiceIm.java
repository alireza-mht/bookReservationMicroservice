package io.github.alirezamht.book.service;

import io.github.alirezamht.book.model.Book;
import io.github.alirezamht.book.repository.BookRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Component("bookService")
@Transactional
public class BookServiceIm implements BookService {

    private BookRepository bookRepository;

    public BookServiceIm(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ArrayList<Book> getAllBook() {
        return bookRepository.getAllBy();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.getBooksByBookId(id);
    }

    @Override
    public void update(Book book) {
        bookRepository.update(book.getName(),book.getBookId(),book.getWriter(),book.getYear(),book.getPrintNum(),
                book.getIsbnNum(),book.getInventory(),book.getPhoto());
    }

    @Override
    public void insert(Book book) {
        bookRepository.insert(book.getName(),book.getWriter(),book.getYear(),book.getPrintNum(),
                book.getIsbnNum(),book.getInventory(),book.getPhoto() );
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteByBookId(id);
    }


}
