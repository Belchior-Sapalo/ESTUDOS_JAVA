package com.estudosjava.exercicios.Movies;

import java.util.ArrayList;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        Actor actor1 = new Actor("Belchior", 2004);
        Actor actor2 = new Actor("Paulo", 2001);
        Actor actor3 = new Actor("Luisa", 1982);
        Actor actor4 = new Actor("Angelino", 2005);
        List<Actor> actors = new ArrayList<>();
        actors.add(actor1);
        actors.add(actor2);
        actors.add(actor3);
        actors.add(actor4);

        Director director1 = new Director("Agostinho", 1980);
        Film film1 = new Film("Amor", 2025, "Romance", director1, actors);
        Film film2 = new Film("Guerra", 2024, "Trama", director1, actors);
        Film film3 = new Film("Bell", 2024, "Trama", director1, actors);

        Library library = new Library();

        library.loadListOfMoviesFromFile();
        library.getFilms();
    }
}
