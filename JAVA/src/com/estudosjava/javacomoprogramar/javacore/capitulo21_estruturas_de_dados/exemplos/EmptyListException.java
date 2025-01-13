package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exemplos;

public class EmptyListException extends RuntimeException{
    public EmptyListException(){
        super("Lista vazia");
    }
}
