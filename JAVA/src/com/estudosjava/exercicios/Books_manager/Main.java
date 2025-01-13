package com.estudosjava.exercicios.Books_manager;

public class Main {
    public static void main(String[] args) {

        BookDAO bookRepositoryDB = new BookRepositoryDB();
        BookDAO bookRepositoryFile = new BookRepositoryFile();
        BookService bookService = new BookService(bookRepositoryFile);
        BookController bookController = new BookController(bookService);

        bookController.start();
    }
}
