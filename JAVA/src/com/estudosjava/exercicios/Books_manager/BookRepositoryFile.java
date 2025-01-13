package com.estudosjava.exercicios.Books_manager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryFile implements BookDAO{
    private static List<Book> listOfResults = new ArrayList<Book>();
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    @Override
    public void addBook(Book newBook) throws Exception {
        try {
            outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("books_manager.ser")));
            inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("books_manager.ser")));
            try {
                while (true){
                    Book book = (Book) inputStream.readObject();
                    listOfResults.add(book);
                }
            }catch (Exception e){
                for (Book book : listOfResults){
                    outputStream.writeObject(book);
                }
                outputStream.writeObject(newBook);
            }
        }catch (IOException e){
            throw new Exception(e);
        }
    }

    @Override
    public Book getBook(int id) throws Exception {
        try {
            inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("books_manager.ser")));
            try {
                while (true){
                    Book book = (Book) inputStream.readObject();
                    if (book.getId() == id){
                        return book;
                    }
                }
            }catch (EOFException e){
                return null;
            }
        }catch (IOException e){
            throw new Exception();
        }finally {
            if (inputStream != null){
                inputStream.close();
            }
        }
    }

    @Override
    public List<Book> getAllBooks() throws Exception {
        try{
            inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("books_manager.ser")));
            try{
                while (true){
                    Book book = (Book) inputStream.readObject();
                    listOfResults.add(book);
                }
            }catch (EOFException e){
                System.out.println();
            }
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            if (inputStream != null){
                inputStream.close();
            }
        }
        return listOfResults;
    }

    @Override
    public void updateBook(Book newBook) throws Exception {
        try{
            outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("books_manager.ser")));
            inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("books_manager.ser")));
            try{
                while (true){
                    Book book = (Book) inputStream.readObject();
                    listOfResults.add(book);
                }
            }catch (EOFException e){
                System.out.println();
            }
            for (Book book : listOfResults){
                if (book.getId() == newBook.getId()){
                    book.setAuthor(newBook.getAuthor());
                    book.setTitle(newBook.getTitle());
                    book.setPrice(newBook.getPrice());
                    outputStream.writeObject(book);
                }else
                    outputStream.writeObject(book);
            }

        }catch (Exception e){
            throw new Exception(e);
        }finally {
            if (inputStream != null)
                inputStream.close();
            if (outputStream != null)
                outputStream.close();
        }
    }

    @Override
    public void deleteBook(int id) throws Exception {
        try{
            outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("books_manager.ser")));
            inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("books_manager.ser")));
            try{
                while (true){
                    Book book = (Book) inputStream.readObject();
                    listOfResults.add(book);
                }
            }catch (EOFException e){
                System.out.println();
            }
            for (Book book : listOfResults){
                if (book.getId() != id)
                    outputStream.writeObject(book);
            }
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            if (inputStream != null)
                inputStream.close();
            if (outputStream != null)
                outputStream.close();
        }
    }

    @Override
    public List<Book> getBooksByAuthorOrTitle(String key) throws Exception {
        try{
            inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("books_manager.ser")));
            try{
                while (true){
                    Book book = (Book) inputStream.readObject();
                    if(book.getAuthor().equals(key) || book.getTitle().equals(key)){
                        listOfResults.add(book);
                    }
                }
            }catch (EOFException e){
                System.out.println("No more books");
            }
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            if (inputStream != null){
                inputStream.close();
            }
        }
        return listOfResults;
    }
}
