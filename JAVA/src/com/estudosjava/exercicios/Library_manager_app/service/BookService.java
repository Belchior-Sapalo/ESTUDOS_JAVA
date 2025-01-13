package com.estudosjava.exercicios.Library_manager_app.service;

import com.estudosjava.exercicios.Library_manager_app.models.BookModel;
import com.estudosjava.exercicios.Library_manager_app.repository.BookRepository;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(BookModel book) throws SQLException {
        bookRepository.addBook(book);
    }

    public BookModel getBookById(int id) throws SQLException {
        return bookRepository.getBookById(id);
    }

    public List<BookModel> getBookByTitleOrAuthor(String key) throws SQLException {
        return bookRepository.getBookByTitleOrAuthor(key);
    }

    public List<BookModel> getAllBooks() throws SQLException {
        return bookRepository.getAllBooks();
    }

    public void updateBook(BookModel book) throws SQLException {
        bookRepository.updateBook(book);
    }

    public void deleteBook(int id) throws SQLException {
        bookRepository.deleteBook(id);
    }
}
