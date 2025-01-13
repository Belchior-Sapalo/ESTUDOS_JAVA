package com.estudosjava.javacomoprogramar.javacore.capitulo20_classes_metodos_genericos.exemplos;

public class EmptyStackException extends RuntimeException{
    public EmptyStackException(){
        this("Stack is empty");
    }

    public EmptyStackException(String message){
        super(message);
    }
}
