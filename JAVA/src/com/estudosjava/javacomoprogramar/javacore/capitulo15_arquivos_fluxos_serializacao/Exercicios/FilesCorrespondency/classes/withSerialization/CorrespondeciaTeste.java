package com.estudosjava.javacomoprogramar.javacore.capitulo15_arquivos_fluxos_serializacao.Exercicios.FilesCorrespondency.classes.withSerialization;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CorrespondeciaTeste {
    private static ObjectOutputStream outputStream;
    private static ObjectInputStream inputStream;
    public static void main(String[] args) {
        String teste = "teste";
        System.out.println(teste.contains("e"));
    }

    public static void openTransactionFileForWriting(){
        try{
            outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("books_manager.ser")));
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void openTransactionFileForRead(){
        try{
            inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("books_manager.ser")));
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void addTransactionRecord(){
        Scanner input = new Scanner(System.in);
        System.out.printf(
                "Insira os dados na ordem: %s, %s, ou ctrl+D para terminar%n? ",
                "numero de conta",
                "valor da transacao"
        );

        while (input.hasNext()){
            try{
                TransationRecord record = new TransationRecord(input.nextInt(), input.nextDouble());
                outputStream.writeObject(record);
            }catch (IOException e){
                System.out.println(e.getMessage());
                System.exit(1);
            }catch (NoSuchElementException e){
                System.out.println("Entrada invalida. Tente de novo");
                input.nextLine();
            }
        }
    }

    public static void readTransactionFile(){
        System.out.printf("%-10s%-12s%n", "Account", "Balance");
        try{
            while (true){
                TransationRecord record = (TransationRecord) inputStream.readObject();
                System.out.printf("%-10d %.2f%n",
                        record.getAccountNumeber(), record.getTransactionAmount()
                );
            }
        }catch (EOFException e){
            System.out.println("Sem mais elementos");
            System.exit(1);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void openAccountFileForWriting(){
        try{
            outputStream =  new ObjectOutputStream(Files.newOutputStream(Paths.get("account.ser")));
        }catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void openAccountFileForRead(){
        try{
            inputStream =  new ObjectInputStream(Files.newInputStream(Paths.get("account.ser")));
        }catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void addAccountRecords(){
        Scanner input = new Scanner(System.in);
        System.out.printf(
                "Insira os dados na ordem: %s, %s, %s, %s ou ctrl+D para terminar%n? ",
                "numero de conta",
                "primeiro nome",
                "segundo nome",
                "saldo"
        );

        while(input.hasNext()){
            try{
                Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());
                outputStream.writeObject(record);
            }catch (IOException e){
                System.out.println(e.getMessage());
                System.exit(1);
            }catch (NoSuchElementException e){
                System.out.println("Entrada invalida. Tente de novo");
                input.nextLine();
            }
        }
    }

    public static void readAccountFile(){
        System.out.printf("%-10s%-12s%-12s%10s%n", "Account","First Name", "Last Name", "Balance");
        try {
            while (true){
                Account record = (Account) inputStream.readObject();
                System.out.printf("%-10d%-12s%-12s%10.2f%n",
                        record.getAccount(), record.getFirstName(),
                        record.getLastName(), record.getBalance()
                );
            }
        }catch (EOFException e){
            System.out.println("Sem mais elementos");
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void closeFiles(){
        if(inputStream != null){
            try {
                inputStream.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }

        if(outputStream != null){
            try {
                outputStream.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
