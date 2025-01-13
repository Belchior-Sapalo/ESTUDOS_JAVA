package com.estudosjava.exercicios.Library_manager_app.controllers;

import com.estudosjava.exercicios.Library_manager_app.models.UserModel;
import com.estudosjava.exercicios.Library_manager_app.models.UserRoleEnum;
import com.estudosjava.exercicios.Library_manager_app.service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class AuthController {
    private UserService userService;
    private Scanner scanner;

    public AuthController(UserService userService) {
        this.userService = userService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n*** Authenticate user ***\n");
            System.out.println("1. Create account");
            System.out.println("2. Login");
            System.out.println("3. Back");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    sigIn();
                    break;
                case 2:
                    logIn();
                    break;
                case 3:
                    return;
                case 4:
                    System.exit(0);
            }
        }
    }

    private void sigIn() {
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        System.out.println("Enter your role: ");
        System.out.println("1. AMIN");
        System.out.println("2. CLIENTE");
        System.out.print("Enter your choice: ");
        int roleChoised = scanner.nextInt();
        UserRoleEnum role = UserRoleEnum.CLIENT;
        switch (roleChoised) {
            case 1:
                role = UserRoleEnum.ADMIN;
                break;
            case 2:
                role = UserRoleEnum.CLIENT;
                break;
        }
        try {
            userService.signIn(new UserModel(0, name, email, password, role));
            System.out.println("User created");
        } catch (SQLException e) {
            System.out.println("There was an error signing in: " + e.getMessage());
        }
    }

    private void logIn() {
        while (true) {
            System.out.println("Email: ");
            String email = scanner.nextLine();
            System.out.println("Password: ");
            String password = scanner.nextLine();
            UserModel logged;
            try {
                logged = userService.login(email, password);

                if (logged == null) {
                    System.out.println("Email or password wrong. Try again");
                    break;
                } else {
                    System.out.println("User logged");
                    System.out.println(logged);
                    return;
                }
            } catch (SQLException e) {
                System.out.println("There was an error login: " + e.getMessage());
            }
        }
    }
}
