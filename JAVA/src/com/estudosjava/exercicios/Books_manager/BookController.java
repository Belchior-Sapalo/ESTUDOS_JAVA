package com.estudosjava.exercicios.Books_manager;

import java.util.List;
import java.util.Scanner;

public class BookController {
    private BookService bookService;
    private Scanner scanner;

    public BookController(BookService bookService) {
        this.bookService = bookService;
        scanner = new Scanner(System.in);
    }

    public void start(){
        while(true){
            System.out.println("1. Add book");
            System.out.println("2. View book");
            System.out.println("3. View all books");
            System.out.println("4. Search book");
            System.out.println("5. Update book");
            System.out.println("6. Delete book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1: addBook(); break;
                    case 2: viewBook(); break;
                    case 3: viewAllBooks(); break;
                    case 4: searchBook(); break;
                    case 5: updateBook(); break;
                    case 6: deleteBook(); break;
                    case 7: System.exit(0);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void addBook() throws Exception {
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter author: ");
        String author = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        Book newBook = new Book(id, title, author, price);

        bookService.addBook(newBook);
        System.out.println("Book added");
    }

    private void viewBook() throws Exception {
        System.out.println("Enter book id: ");
        int id = scanner.nextInt();

        Book book = bookService.getBook(id);
        if(book != null)
            System.out.println(book);
        System.out.println("Book not found");
    }

    private void viewAllBooks() throws Exception {
        if(bookService.getAllBooks() != null){
            List<Book> books = bookService.getAllBooks();
            books.stream().forEach(System.out::println);
        }else{
            System.out.println("No books found");
        }
    }

    private void searchBook() throws Exception {
        System.out.println("Enter title or author: ");
        String key = scanner.nextLine();

        List<Book> books = bookService.getBooksByAuthorOrTitle(key);
        books.stream().forEach(System.out::println);
    }

    private void updateBook() throws Exception {
        System.out.println("Enter book id: ");
        int id = scanner.nextInt();
        Book book = bookService.getBook(id);

        if(book != null){
            System.out.println("Enter new title: ");
            String title = scanner.next();
            System.out.println("Enter new author: ");
            String author = scanner.next();
            System.out.println("Enter new price: ");
            double price = scanner.nextDouble();

            book.setTitle(title);
            book.setAuthor(author);
            book.setPrice(price);

            bookService.updateBook(book);
            System.out.println("Book updated");
        }else{
            System.out.println("Book not found");
        }
    }

    private void deleteBook() throws Exception {
        System.out.println("Enter book id: ");
        int id = scanner.nextInt();

        Book book = bookService.getBook(id);

        if(book != null){
            bookService.deleteBook(book.getId());
            System.out.println("Book deleted");
        }else{
            System.out.println("Book not found");
        }
    }
}
