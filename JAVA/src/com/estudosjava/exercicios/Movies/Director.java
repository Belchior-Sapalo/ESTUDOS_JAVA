package com.estudosjava.exercicios.Movies;

import java.util.ArrayList;
import java.util.List;

public class Director extends Person{
    List<Film> listOfMovies;
    public Director(String nome, int birthYear){
        super(nome, birthYear);
        listOfMovies = new ArrayList<>();
    }

    public void addOneFilm(Film film){
        listOfMovies.add(film);
    }

    public void setListOfMovies(List<Film> films){
        listOfMovies = films;
    }

    public List<Film> getListOfMovies(){
        return listOfMovies;
    }

    @Override
    public String toString(){
        return String.format("%s%nList of movies: %s%n", super.toString(), listOfMovies.isEmpty() ? "No movies" : listOfMovies);
    }
}
