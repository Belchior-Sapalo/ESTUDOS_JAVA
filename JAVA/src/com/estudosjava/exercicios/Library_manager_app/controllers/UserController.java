package com.estudosjava.exercicios.Library_manager_app.controllers;

import com.estudosjava.exercicios.Library_manager_app.models.BookModel;
import com.estudosjava.exercicios.Library_manager_app.models.UserModel;
import com.estudosjava.exercicios.Library_manager_app.service.BookService;
import com.estudosjava.exercicios.Library_manager_app.service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserController {
    private UserService userService;
    private BookService bookService;
    private Scanner scanner;

    public UserController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n*** User dashboard ***\n");
            System.out.println("1. Get all users");
            System.out.println("2. Search users");
            System.out.println("3. Search user by id");
            System.out.println("4. Add book");
            System.out.println("5. Get all books");
            System.out.println("6. Delete book");
            System.out.println("7. Update book");
            System.out.println("8. Get book by title or author");
            System.out.println("9. Back");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    getAllUsers();
                    break;
                case 2:
                    getUserByUserName();
                    break;
                case 3:
                    getUserById();
                    break;
                case 4:
                    addBook();
                    break;
                case 5:
                    getAllBooks();
                    break;
                case 6:
                    deleteBook();
                    break;
                case 7:
                    updateBook();
                    break;
                case 8:
                    getBooksByAuthorOrTitle();
                    break;
                case 9:
                    return;
                case 10:
                    System.exit(0);
            }
        }
    }

    private void getAllUsers() {
        try {
            List<UserModel> users = userService.getAllUsers();
            if (users.isEmpty())
                System.out.println("List of users is empty");
            else
                users.stream().forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void getUserByUserName() {
        System.out.println("Enter user name: ");
        String userName = scanner.nextLine();
        try {
            List<UserModel> users = userService.getUserByUserName(userName);
            if (users.isEmpty())
                System.out.println("User not found");
            else
                users.stream().forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void getUserById() {
        System.out.println("Enter user id: ");
        int id = scanner.nextInt();
        try {
            UserModel user = userService.getUserById(id);
            if (user == null)
                System.out.println("User not found");
            else
                System.out.println(user);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addBook() {
        while (true) {
            try {
                System.out.println("Enter user id: ");
                int id = scanner.nextInt();
                UserModel user = userService.getUserById(id);
                scanner.nextLine();
                if (user == null) {
                    System.out.println("User not found, Try again");
                    break;
                } else {
                    if (user.getRole().getValue() == 1) {
                        System.out.println("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.println("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.println("Enter price: ");
                        double price = scanner.nextDouble();
                        System.out.println("Is the book available? (Y/N): ");
                        String availability = scanner.next();
                        boolean isAvailable = availability.equals("y") ? true : false;
                        bookService.addBook(new BookModel(0, title, author, price, isAvailable));
                        System.out.println("Book added");
                        return;
                    } else
                        System.out.println("You cannot add book. You must be an admin");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void deleteBook() {
        while (true) {
            try {
                System.out.println("Enter user id: ");
                int userId = scanner.nextInt();
                UserModel user = userService.getUserById(userId);
                scanner.nextLine();
                if (user == null) {
                    System.out.println("User not found, Try again");
                    break;
                } else {
                    if (user.getRole().getValue() == 1) {
                        System.out.println("Enter book id: ");
                        int id = scanner.nextInt();
                        BookModel book = bookService.getBookById(id);
                        if (book == null) {
                            System.out.println("Book not found, Try again");
                            return;
                        } else {
                            bookService.deleteBook(book.getId());
                            System.out.println("Book deleted");
                            break;
                        }
                    } else
                        System.out.println("You cannot add book. You must be an admin");
                }

            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void updateBook() {
        while (true) {
            try {
                System.out.println("Enter user id: ");
                int userId = scanner.nextInt();
                UserModel user = userService.getUserById(userId);
                scanner.nextLine();
                if (user == null) {
                    System.out.println("User not found, Try again");
                    break;
                } else {
                    if (user.getRole().getValue() == 1) {
                        System.out.println("Enter book id: ");
                        int id = scanner.nextInt();
                        BookModel book = bookService.getBookById(id);
                        scanner.nextLine();
                        if (book != null) {
                            System.out.println("Enter title: ");
                            String title = scanner.nextLine();
                            System.out.println("Enter author: ");
                            String author = scanner.nextLine();
                            System.out.println("Enter price: ");
                            double price = scanner.nextDouble();
                            System.out.println("Is the book available? (Y/N): ");
                            String availability = scanner.next();
                            boolean isAvailable = availability.equals("y") ? true : false;
                            bookService.updateBook(new BookModel(id, title, author, price, isAvailable));
                            System.out.println("Book updated");
                            break;
                        } else {
                            System.out.println("Book not founded");
                        }

                    } else
                        System.out.println("You cannot add book. You must be an admin");
                }

            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void getAllBooks() {
        try {
            List<BookModel> books = bookService.getAllBooks();
            if (books.isEmpty())
                System.out.println("List of books is empty");
            else
                books.stream().forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void getBooksByAuthorOrTitle() {
        try {
            System.out.println("Enter book title or book author: ");
            String key = scanner.next();
            List<BookModel> books = bookService.getBookByTitleOrAuthor(key);
            if (books.isEmpty())
                System.out.println("List of books is empty");
            else
                books.stream().forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
