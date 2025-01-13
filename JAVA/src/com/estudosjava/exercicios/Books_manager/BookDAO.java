package com.estudosjava.exercicios.Books_manager;

import java.util.List;

public interface BookDAO {
    void addBook(Book book) throws Exception;
    Book getBook(int id) throws Exception;
    List<Book> getAllBooks() throws Exception;
    void updateBook(Book book) throws Exception;
    void deleteBook(int id) throws Exception;
    List<Book> getBooksByAuthorOrTitle(String key) throws Exception;
}
