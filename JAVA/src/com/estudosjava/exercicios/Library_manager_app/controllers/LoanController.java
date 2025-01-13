package com.estudosjava.exercicios.Library_manager_app.controllers;

import com.estudosjava.exercicios.Library_manager_app.models.LoanModel;
import com.estudosjava.exercicios.Library_manager_app.models.UserModel;
import com.estudosjava.exercicios.Library_manager_app.models.UserRoleEnum;
import com.estudosjava.exercicios.Library_manager_app.service.LoanService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LoanController {
    private LoanService loanService;
    private Scanner scanner = new Scanner(System.in);

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    public void start() {
        while (true) {
            System.out.println("\n*** Loan menu ***\n");
            System.out.println("1. Add loan");
            System.out.println("2. Get all loans");
            System.out.println("3. Get loan");
            System.out.println("4. Get loan by user");
            System.out.println("5. Return loan");
            System.out.println("6. Back");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    addLoan();
                    break;
                case 2:
                    getAllLoans();
                    break;
                case 3:
                    getLoan();
                    break;
                case 4:
                    getLoanByUser();
                    break;
                case 5:
                    returnLoan();
                    break;
                case 6:
                    return;
                case 7:
                    System.exit(0);
            }
        }
    }

    private void addLoan() {
        System.out.println("User id: ");
        int userId = scanner.nextInt();
        System.out.println("Book id: ");
        int bookId = scanner.nextInt();
        try {
            LoanModel newLoan = new LoanModel(0, userId, bookId, new java.sql.Date(System.currentTimeMillis()), null);
            loanService.addLoan(newLoan);
            System.out.println("Loan added successfully!");
        } catch (SQLException e) {
            System.out.println("There was an error adding loan: " + e.getMessage());
        }
    }

    private void getAllLoans() {
        try {
            List<LoanModel> listOfResults = loanService.getAllLoans();

            if (listOfResults.isEmpty()) {
                System.out.println("No loans found");
            } else
                listOfResults.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void getLoan() {
        System.out.println("Enter loan id: ");
        int id = scanner.nextInt();
        try {
            LoanModel loan = loanService.getLoan(id);
            if (loan == null)
                System.out.println("Loan not found");
            else
                System.out.println(loan);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void getLoanByUser() {
        System.out.println("Enter user id: ");
        int id = scanner.nextInt();
        try {
            List<LoanModel> listOfResults = loanService.getLoanByUser(id);
            if (listOfResults.isEmpty())
                System.out.println("No loans found");
            else
                listOfResults.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void returnLoan() {
        System.out.println("Enter loan id: ");
        int id = scanner.nextInt();
        try {
            if(loanService.returnLoan(id))
                System.out.println("Loan returned successfully!");
            else
                System.out.println("This loan does not exist");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
