package com.estudosjava.javacomoprogramar.javacore.capitulo20_classes_metodos_genericos.exemplos;

public class InvalidSubscriptException extends RuntimeException{
    public InvalidSubscriptException() {
        super("Intervalo invalido");
    }
}
