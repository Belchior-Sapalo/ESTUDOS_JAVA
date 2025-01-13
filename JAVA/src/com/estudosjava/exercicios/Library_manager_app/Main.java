package com.estudosjava.exercicios.Library_manager_app;

import com.estudosjava.exercicios.Library_manager_app.controllers.AuthController;
import com.estudosjava.exercicios.Library_manager_app.controllers.LoanController;
import com.estudosjava.exercicios.Library_manager_app.controllers.UserController;
import com.estudosjava.exercicios.Library_manager_app.repository.BookRepository;
import com.estudosjava.exercicios.Library_manager_app.repository.LoanRepository;
import com.estudosjava.exercicios.Library_manager_app.repository.UserRepository;
import com.estudosjava.exercicios.Library_manager_app.service.BookService;
import com.estudosjava.exercicios.Library_manager_app.service.LoanService;
import com.estudosjava.exercicios.Library_manager_app.service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/library_manager_app";
        final String DATABASE_USER = "root";
        final String DATABASE_PASSWORD = "";
        Scanner scanner = new Scanner(System.in);

        UserRepository userRepository = new UserRepository(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        BookRepository bookRepository = new BookRepository(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        LoanRepository loanRepository = new LoanRepository(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        UserService userService = new UserService(userRepository);
        BookService bookService = new BookService(bookRepository);
        LoanService loanService = new LoanService(loanRepository);
        AuthController auth = new AuthController(userService);
        UserController userController = new UserController(userService, bookService);
        LoanController loanController = new LoanController(loanService);

        while (true){
            System.out.println("\n*** Welcome to Library Manager App ***\n");
            System.out.println("1. Authenticate User");
            System.out.println("2. User dashboard");
            System.out.println("3. Loan menu");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1: auth.start(); break;
                case 2: userController.start(); break;
                case 3: loanController.start(); break;
                case 4: System.exit(0);
            }
        }
    }
}
