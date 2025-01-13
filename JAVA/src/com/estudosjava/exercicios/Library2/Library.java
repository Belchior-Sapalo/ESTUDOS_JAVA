package com.estudosjava.exercicios.Library2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library implements Serializable{
    public static final String PATH_OF_BOOKS = "books.ser";
    List<Book> booksInLibrary;

    public Library() {
        booksInLibrary = new ArrayList<>();
    }

    public void addBook(Book book) throws BookAlredyExistsException{
        for(Book currencyBook : booksInLibrary) {
            if(currencyBook.getISBN().equals(book.getISBN()))
                throw new BookAlredyExistsException();
        }
        booksInLibrary.add(book);
    }

    public void removeBook(String isbn) throws EspecifiedBookNotExistsException{
        boolean removed = booksInLibrary.removeIf(book -> book.getISBN().equals(isbn.toUpperCase()));

        if (!removed)
            throw new EspecifiedBookNotExistsException();
    }

    public List<Book> getBooksInLibrary() {
        return booksInLibrary;
    }

    public List<Book> searchBook(String keyword) {
        List<Book> listOfResult = booksInLibrary.stream()
                .filter(
                        book -> book.getTitle().toLowerCase().equals(keyword.toLowerCase())
                                || book.getAuthor().toLowerCase().equals(keyword.toLowerCase())
                )
                .collect(Collectors.toList());

        return listOfResult;
    }

    public void getBooksFromAFile() {
        System.out.println("Books from library file");
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(PATH_OF_BOOKS))){
            while (true){
                Book bookInFile = (Book) reader.readObject();
                System.out.println(bookInFile);
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (EOFException e){
            System.out.println("No more books in library file");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setBooksInFile(Book newBook){
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(PATH_OF_BOOKS))){
            writer.writeObject(newBook);
            System.out.println("Book added to the library's file");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
