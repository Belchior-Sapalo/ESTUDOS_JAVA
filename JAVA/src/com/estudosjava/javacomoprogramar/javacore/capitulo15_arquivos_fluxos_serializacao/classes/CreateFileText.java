package com.estudosjava.javacomoprogramar.javacore.capitulo15_arquivos_fluxos_serializacao.classes;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateFileText {
    private static Formatter output;
    public static void main(String[] args) {
        openFile();
        addRecords();
        closeFile();
    }

    public static void openFile(){
        try{
            //Formatter gera saida de dados para um destino especificado, no caso, clientes.txt
            output = new Formatter("clientes.txt");
            System.out.println("aberto");
        }catch (SecurityException securityException){
            System.err.println("Sem permissa de escrita. Terminando");
            System.exit(1);
        }catch (FileNotFoundException fileNotFoundException){
            System.err.println("Erro ao abrir o arquivo. Terminando");
            System.exit(1);
        }
    }

    public static void addRecords(){
        Scanner input = new Scanner(System.in);
        System.out.printf("%s%n%s%n? ",
                "Enter account number, first name, last name and balance.",
                "Enter end-of-file indicator to end input."
        );

        while(input.hasNext()){
            try{
                //O metodo format() envia dados formatados para o destino do objecto Formatter (output, clientes.txt)
                output.format("%d %s %s %.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
            }catch (FormatterClosedException formatterClosedException){
                System.err.println("Error writing to file. Terminating.");
                break;
            }catch (NoSuchElementException noSuchElementException){
                System.err.println("Invalid input. Please try again.");
                input.nextLine();
            }
            System.out.print("? ");
        }
    }

    public static void closeFile(){
        if(output != null)
            output.close();
    }
}
