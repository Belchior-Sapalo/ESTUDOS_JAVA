package com.estudosjava.javacomoprogramar.javacore.capitulo15_arquivos_fluxos_serializacao.CreditInquiry;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreditInquity {
    private final static MenuOptions[] choises = MenuOptions.values();

    public static void main(String[] args) {
        MenuOptions accountType = getRequest();

        while (accountType != MenuOptions.END) {
            switch (accountType) {
                case ZERO_BALANCE -> System.out.printf("%nAccounts with zero balances:%n");
                case CREDIT_BALANCE -> System.out.printf("%nAccounts with credit balances:%n");
                case DEBIT_BALANCE -> System.out.printf("%nAccounts with debit balances:%n");
            }
            readRecords(accountType);
            accountType = getRequest();
        }
    }

    public static MenuOptions getRequest(){
        int request = 4;
        System.out.printf("%nEnter request%n%s%n%s%n%s%n%s%n",
                " 1 - List accounts with zero balances",
                " 2 - List accounts with credit balances",
                " 3 - List accounts with debit balances",
                " 4 - Terminate program"
        );

        try {
            Scanner input = new Scanner(System.in);
            do{
                System.out.printf("%n? ");
                request = input.nextInt();
            }while ((request < 1) || request > 4);
        }catch (NoSuchElementException noSuchElementException){
            System.err.println("Invalid input. Terminating.");
        }

        return choises[request - 1];
    }

    public static void readRecords(MenuOptions accountType){
        try(Scanner input = new Scanner(Paths.get("clientes.txt"))){
            while (input.hasNextLine()){
                int accountNumber = input.nextInt();
                String firstName = input.next();
                String lastName = input.next();
                double balance = input.nextDouble();

                if (shouldDisplay(accountType, balance))
                    System.out.printf("%-10d%-12s%-12s%10.2f%n", accountNumber,firstName, lastName, balance);
                else
                    input.nextLine();

            }
        }catch (NoSuchElementException | IllegalStateException | IOException e){
            System.err.println("Error processing file. Terminating.");
            System.exit(1);
        }
    }

    private static boolean shouldDisplay(MenuOptions accountType, double balance){
        if((accountType == MenuOptions.CREDIT_BALANCE) && (balance < 0))
            return true;
        if((accountType == MenuOptions.DEBIT_BALANCE) && (balance > 0))
            return true;
        else if((accountType == MenuOptions.ZERO_BALANCE) && (balance == 0))
            return true;
        return false;
    }
}
