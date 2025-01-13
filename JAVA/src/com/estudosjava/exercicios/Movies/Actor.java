package com.estudosjava.exercicios.Movies;

import java.util.ArrayList;
import java.util.List;

public class Actor extends Person{
    private List<Film> films;
    public Actor(String name, int birthyear) {
        super(name, birthyear);
        this.films = new ArrayList<>();
    }

    @Override
    public String toString(){
        return String.format("%s%nList of movies: %s%n", super.toString(), films.isEmpty() ? "No movies" : films);
    }
}
