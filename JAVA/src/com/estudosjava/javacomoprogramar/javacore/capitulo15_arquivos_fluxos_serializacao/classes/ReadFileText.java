package com.estudosjava.javacomoprogramar.javacore.capitulo15_arquivos_fluxos_serializacao.classes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadFileText {
    private static Scanner input;
    public static void main(String[] args) {
        openFile();
        readFile();
        closeFile();
    }

    public static void openFile(){
        try{
            //O metodo static Paths get() retorna um objecto path que representa o arquivo ou directorio
            //passado como argumento (clientes.txt)
            //O Paths.get("clientes.txt") indica que o fluxo de entrada de dados vira a partir do arquivo clentes.txt, representado pelo path
            //que esse metodo retorna
            input = new Scanner(Paths.get("clientes.txt"));
        }catch (IOException e){
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }

    public static void readFile(){
        System.out.printf("%-10s%-12s%-12s%10s%n", "Account", "First Name", "Last Name", "Balance");

        try{
            while (input.hasNext()){
                System.out.printf("%-10d%-12s%-12s%10.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
            }
        }catch (NoSuchElementException noSuchElementException){
            System.err.println("File improperly formed. Terminating.");
        }catch (IllegalStateException illegalStateException){
            System.err.println("Error reading from file. Terminating.");
        }
    }

    public static void closeFile(){
        if(input != null){
            input.close();
        }
    }
}
