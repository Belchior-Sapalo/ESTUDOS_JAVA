package com.estudosjava.exercicios.Library2;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    private static final String PATH_OF_LIBRARY = "library.ser";
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
      loadLibraryFromFile();
      while (true){
          showMenu();
          int option = scanner.nextInt();
          switch(option){
              case 1: addBookToLibrary(); break;
              case 2: removeBookFromLibrary(); break;
              case 3: searchBookInLibrary(); break;
              case 4: showAllBooksFromLibrary(); break;
              case 5: saveLibraryToFile(); break;
              case 6: loadLibraryFromFile(); break;
              case 7: System.exit(0); break;
              default: System.out.println("Invalid option");
          }
      }
    }

    public static void showMenu(){
        System.out.println("Library management system");
        System.out.println("1. Add book");
        System.out.println("2. Remove book");
        System.out.println("3. Search book");
        System.out.println("4. Show all books");
        System.out.println("5. Save library");
        System.out.println("6. Load library");
        System.out.println("7. Exit");
        System.out.println("Enter your choice: ");
    }

    public static void addBookToLibrary() {
        System.out.print("Enter the title of the book: ");
        String title = scanner.next();
        System.out.print("Enter the author of the book: ");
        String author = scanner.next();
        System.out.print("Enter the year of the book: ");
        int year = scanner.nextInt();
        String isbn = generateISBN(title, author, year);
        try {
            library.addBook(new Book(title, author, isbn, year));
            System.out.println("Book added to library");
        }catch (BookAlredyExistsException e){
            System.out.printf("%n%s%n","*Book already exists*");
        }
    }

    private static String generateISBN(String bookTitle, String bookauthor, int bookyear) {
        Character[] ch = {bookTitle.charAt(0), bookauthor.charAt(0)};
        String ISBN = "";
        for(Character c : ch){
            ISBN += c;
        }
        return (ISBN + bookyear).toUpperCase();
    }

    public static void removeBookFromLibrary() {
        System.out.print("Enter the ISBN of the book: ");
        String isbn = scanner.next();
        try {
            library.removeBook(isbn);
            System.out.println("Book removed");
        }catch (EspecifiedBookNotExistsException e){
            System.out.printf("%n%s%n","*This book does not exits*");
        }
    }

    public static void searchBookInLibrary() {
        System.out.print("Enter the keyword of the book: ");
        String keyword = scanner.next();
        List<Book> listOfResults = library.searchBook(keyword);
        if(listOfResults.isEmpty())
            System.out.printf("%n%s%n","*This book does not exits*");
        listOfResults.stream().forEach(System.out::println);
    }

    public static void showAllBooksFromLibrary(){
        List<Book> listOfBooksInLibrary = library.getBooksInLibrary();
        if(listOfBooksInLibrary.isEmpty())
            System.out.printf("%n%s%n","*This library is empty*");
        else{
            System.out.printf("%n%s%n","*All Library's books*");
            listOfBooksInLibrary.stream().forEach(System.out::println);
        }
    }

    public static void loadLibraryFromFile() {
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(PATH_OF_LIBRARY))) {
            library = (Library) input.readObject();
            System.out.printf("%n%s%n", "*Library loaded*");
        }catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveLibraryToFile() {
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(PATH_OF_LIBRARY))) {
            output.writeObject(library);
            System.out.printf("%n%s%n", "*Library saved*");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
