package com.estudosjava.javacomoprogramar.javacore.capitulo15_arquivos_fluxos_serializacao.Exercicios.FilesCorrespondency.classes.whitoutSerealization;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileMatch {
    private static Scanner inputOldMasterFile;
    private static Scanner inputTransFile;
    private static Formatter outputNewMast;
    private static Formatter outputLogFile;

    public static void searchMatchtIfExists(){
        openNewMastFile();
        try{
            inputOldMasterFile = new Scanner(Paths.get("oldmast.txt"));
            while (inputOldMasterFile.hasNext()){
                int accountNumber = inputOldMasterFile.nextInt();
                String firstName = inputOldMasterFile.next();
                String lastName = inputOldMasterFile.next();
                double balance = inputOldMasterFile.nextDouble();

                if(
                        verifyIfAccountNumberExistsOnlyOneOldmastFile(accountNumber) ||
                        verifyIfAccountNumberExistsInTwoFiles(accountNumber)
                ){
                    double amount = getAmountOfAccountNumber(accountNumber);
                    generateNewMastFile(accountNumber, firstName, lastName, balance, amount);
                }
            }
        }catch (NoSuchElementException e){
            System.out.println("Falha ao ler arquivo");
        }catch (IOException e){
            System.out.println("Falha ao ler arquivo");
            System.exit(1);
        }finally {
            generateLogFile();
            closeAllFiles();
        }
    }

    public static void generateLogFile(){
        try{
            outputLogFile = new Formatter("log.txt");
            inputTransFile = new Scanner(Paths.get("trans.txt"));
            while (inputTransFile.hasNext()){
                int accountNumber = inputTransFile.nextInt();
                double amount = inputTransFile.nextDouble();
                if(verifyIfAccountNumberExistsOnlyInTransFile(accountNumber)){
                    outputLogFile.format("%s %d%n", "Registro de transação não correspondente para o número da conta", accountNumber);
                }
            }
        }catch (IOException e){
            System.out.println("Falha ao ler arquivo");
            System.exit(1);
        }finally {
            if(outputLogFile != null)
                outputLogFile.close();
        }
    }

    public static boolean verifyIfAccountNumberExistsOnlyInTransFile(int accountNumber){
        try {
            inputOldMasterFile = new Scanner(Paths.get("oldmast.txt"));
            while (inputOldMasterFile.hasNext()){
                int accounterNumberInOldMast = inputOldMasterFile.nextInt();
                String firstName = inputOldMasterFile.next();
                String lastName = inputOldMasterFile.next();
                double balance = inputOldMasterFile.nextDouble();

                if(accounterNumberInOldMast == accountNumber){
                    return false;
                }
            }
        }catch (NoSuchElementException e){
            System.out.println("Falha ao ler arquivo");
            System.exit(1);
        }catch (IOException e){
            System.out.println("Falha ao ler arquivo");
            System.exit(1);
        }
        return true;
    }

    public static boolean verifyIfAccountNumberExistsOnlyOneOldmastFile(int accountNumber){
        try {
            inputTransFile = new Scanner(Paths.get("trans.txt"));
            while (inputTransFile.hasNext()){
                int accounterNumberInTransFile = inputTransFile.nextInt();
                double balance = inputTransFile.nextDouble();

                if(accounterNumberInTransFile == accountNumber){
                    return false;
                }
            }
        }catch (NoSuchElementException e){
            System.out.println("Falha ao ler arquivo");
            System.exit(1);
        }catch (IOException e){
            System.out.println("Falha ao ler arquivo");
            System.exit(1);
        }
        return true;
    }

    public static boolean verifyIfAccountNumberExistsInTwoFiles(int accountNumber){
        try {
            inputTransFile = new Scanner(Paths.get("trans.txt"));
            while (inputTransFile.hasNext()){
                int accounterNumberInTransFile = inputTransFile.nextInt();
                double balance = inputTransFile.nextDouble();

                if(accounterNumberInTransFile == accountNumber){
                    return true;
                }
            }
        }catch (NoSuchElementException e){
            System.out.println("falha ao ler arquivo");
            System.exit(1);
        }catch (IOException e){
            System.out.println("Falha ao ler arquivo");
            System.exit(1);
        }
        return false;
    }

    public static double getAmountOfAccountNumber(int accountNumber){
        double totalOfAmount = 0.0;
        try {
            inputTransFile = new Scanner(Paths.get("trans.txt"));
            while (inputTransFile.hasNext()){
                int accounterNumberInTransFile = inputTransFile.nextInt();
                double amount = inputTransFile.nextDouble();

                if(accounterNumberInTransFile == accountNumber){
                    totalOfAmount += amount;
                }
            }
        }catch (NoSuchElementException e){
            System.out.println("falha ao ler arquivo");
            System.exit(1);
        }catch (IOException e){
            System.out.println("Falha ao ler arquivo");
            System.exit(1);
        }
        return totalOfAmount;
    }

    public static void generateNewMastFile(int accountNumber, String firstName, String lastName, double balance, double amount){
        try{
            outputNewMast.format(
                    "%d %s %s %.2f%n",
                    accountNumber, firstName,
                    lastName, (balance + amount)
            );
        }catch (NoSuchElementException e){
            System.out.println("Falha ao gerar newMaster");
            System.exit(1);
        }
    }

    private static void openNewMastFile(){
        try{
            outputNewMast = new Formatter("newmast.txt");
        }catch (FileNotFoundException e){
            System.err.println("Falha ao abrir arquivos");
            System.exit(1);
        }
    }

    private static void closeAllFiles(){
        if(inputOldMasterFile != null)
            inputOldMasterFile.close();
        if(inputTransFile != null)
            inputTransFile.close();
        if(outputNewMast != null)
            outputNewMast.close();
    }
}
