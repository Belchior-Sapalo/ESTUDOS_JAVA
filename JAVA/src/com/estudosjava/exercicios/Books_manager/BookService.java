package com.estudosjava.exercicios.Books_manager;

import java.util.List;

public class BookService {
    private BookDAO bookDAO;

    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void addBook(Book book)  throws Exception {
        bookDAO.addBook(book);
    }

    public Book getBook(int id) throws Exception {
        return bookDAO.getBook(id);
    }

    public List<Book> getAllBooks() throws Exception{
        return bookDAO.getAllBooks();
    }

    public void updateBook(Book book) throws Exception {
        bookDAO.updateBook(book);
    }

    public void deleteBook(int id) throws Exception {
        bookDAO.deleteBook(id);
    }

    public List<Book> getBooksByAuthorOrTitle(String key) throws Exception{
        return bookDAO.getBooksByAuthorOrTitle(key);
    }
}
