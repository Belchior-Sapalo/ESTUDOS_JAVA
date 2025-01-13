package com.estudosjava.javacomoprogramar.javacore.capitulo15_arquivos_fluxos_serializacao.Exercicios.FilesCorrespondency.classes.whitoutSerealization;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CorrespondeciaTeste {
    private static Formatter output;
    private static Scanner input;
    public static void main(String[] args) {
        FileMatch.searchMatchtIfExists();
    }

    public static void openFile(String fileName){
        try{
            output = new Formatter(fileName);
        }catch (SecurityException e){
            handlerException(e);
        }catch (IOException e){
            handlerException(e);
        }
    }

    public static void addRecordsInOldmast(){
        Scanner input = new Scanner(System.in);
        System.out.printf(
                "Insira os dados na ordem: %s, %s, %s, %s ou ctrl+D para terminar%n? ",
                "numero de conta",
                "primeiro nome",
                "segundo nome",
                "saldo"
        );
       while (input.hasNext()){
           try{
               output.format("%d %s %s %.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
           }catch (FormatterClosedException formatterClosedException){
               System.err.println("Error writing to file. Terminating.");
               break;
           }catch (NoSuchElementException noSuchElementException){
               System.err.println("Entrada invalida. Tente novamente");
               input.nextLine();
           }
       }
    }

    public static void addRecordsTransFile(){
        Scanner input = new Scanner(System.in);
        System.out.printf(
                "Insira os dados na ordem: %s, %s, ou ctrl+D para terminar%n? ",
                "numero de conta",
                "valor da transferencia"
        );
        while (input.hasNext()){
            try{
                output.format("%d %.2f%n", input.nextInt(), input.nextDouble());
            }catch (FormatterClosedException formatterClosedException){
                System.err.println("Error writing to file. Terminating.");
                break;
            }catch (NoSuchElementException noSuchElementException){
                System.err.println("Entrada invalida. Tente novamente");
                input.nextLine();
            }
        }
    }

    public static void readTransFile(){
        try{
            input = new Scanner(Paths.get("trans.txt"));
            while (input.hasNext()){
                    System.out.printf("%d %.2f%n", input.nextInt(), input.nextDouble());
            }
        }catch (IOException e){
            handlerException(e);
        }
    }

    public static void readOldmastFile(){
        try{
            input = new Scanner(Paths.get("oldmast.txt"));
            while (input.hasNext()){
                System.out.printf("%d %s %s %.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
            }
        }catch (IOException e){
            handlerException(e);
        }
    }

    public static void closeOldmastFile(){
        if(output != null){
            output.close();
        }
    }

    public static void closeTransFile(){
        if(output != null){
            output.close();
        }
    }

    public static void handlerException(Exception e){
        e.printStackTrace();
    }
}
