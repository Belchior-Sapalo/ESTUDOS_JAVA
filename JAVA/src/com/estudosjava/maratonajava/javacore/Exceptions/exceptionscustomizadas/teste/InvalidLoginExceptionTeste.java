package com.estudosjava.maratonajava.javacore.Exceptions.exceptionscustomizadas.teste;

import com.estudosjava.maratonajava.javacore.Exceptions.exceptionscustomizadas.classes.Funcionario;
import com.estudosjava.maratonajava.javacore.Exceptions.exceptionscustomizadas.classes.InvalidLoginExeption;
import com.estudosjava.maratonajava.javacore.Exceptions.exceptionscustomizadas.classes.Pessoa;

import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class InvalidLoginExceptionTeste {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pessoa p = new Pessoa();
        Funcionario f = new Funcionario();

        f.salvar();
        try {
            p.salvar();
        }catch (InvalidLoginExeption | FileAlreadyExistsException e){
            e.printStackTrace();
        }
    }

    public static void login(String email, String pass) throws InvalidLoginExeption{

        if(!(email.equals("bell@gmail.com") || pass.equals("teste")))
            throw new InvalidLoginExeption("Email ou password incorreto");
        System.out.println("Login efetuado com sucesso!");
    }
}
