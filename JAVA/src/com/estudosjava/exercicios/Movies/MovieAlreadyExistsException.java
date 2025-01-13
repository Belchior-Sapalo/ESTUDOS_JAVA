package com.estudosjava.exercicios.Movies;

public class MovieAlreadyExistsException extends Exception{
    public MovieAlreadyExistsException(){
        super("Movie already exists");
    }
}
