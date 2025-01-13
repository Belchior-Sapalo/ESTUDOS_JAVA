package com.estudosjava.exercicios.Library2;

public class EspecifiedBookNotExistsException extends Exception{
    public EspecifiedBookNotExistsException(){
        super("Especified Book Not Exists");
    }
}
