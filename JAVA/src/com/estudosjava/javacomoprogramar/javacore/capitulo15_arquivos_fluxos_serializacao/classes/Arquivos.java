package com.estudosjava.javacomoprogramar.javacore.capitulo15_arquivos_fluxos_serializacao.classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;

public class Arquivos {
    private static Formatter output;
    public static void main(String[] args) {
        pesquisar("Agostinho");
        fecharArquivo();
    }

    public static void abrirArquivo() {
        try{
            output = new Formatter("dados.txt");
        }catch (FileNotFoundException e){
            System.err.println("Falha ao abrir arquivo");
            System.exit(1);
        }
    }

    public static void escreverArquivo(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Insira os valores na seguinte orden: %s %s %s %s %s %s%n",
                "ID", "Primerio nome", "Segundo nome", "Email", "Senha", "Ou ctrl+d para encerrar"
        );

        try{
            while(input.hasNext()){
                output.format("%d %s %s %s %s%n", input.nextInt(), input.next(), input.next(), input.next(), input.next());
            }
        }catch (FormatterClosedException e){
            System.out.println("Falha ao escrever arquivo");
            System.exit(1);
        }
    }

    public static void lerArquivo(){
        try(Scanner input = new Scanner(Paths.get("dados.txt"))){
            while (input.hasNext()){
                System.out.printf("%d %s %s %s %s%n", input.nextInt(), input.next(), input.next(), input.next(), input.next());
            }
        }catch (IOException e){
            System.out.println("Falha ao ler arquivo");
            System.exit(1);
        }
    }

    public static void fecharArquivo(){
        if(output != null){
            output.close();
        }
    }

    public static void pesquisar(String nome){
        try(Scanner input = new Scanner(Paths.get("dados.txt"))){
            while (input.hasNext()){
                int idInDb = input.nextInt();
                String primeiroNome = input.next();
                String segundoNome = input.next();
                String email = input.next();
                String senha = input.next();
                if(nome.equals(primeiroNome) || nome.equals(segundoNome)){
                    System.out.printf("%d %s %s %s %s%n", idInDb, primeiroNome, segundoNome, email, senha);
                }else{
                    input.nextLine();
                }
            }
        }catch (IOException e){
            System.err.println("Falha ao pesquisar arquivo");
            System.exit(1);
        }
    }
}
