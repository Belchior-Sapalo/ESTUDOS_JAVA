package com.estudosjava.exercicios.Movies;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class Film implements Serializable {
    private String title;
    private int year;
    private String genre;
    private Director director;
    private String id;
    List<Actor> actors;

    public Film(String title, int year, String genre, Director director, List<Actor> actors) {
        if(year <= 0)
            throw new IllegalArgumentException("Year must be a positive integer");
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.id = generateId(title, year);
    }

    private String generateId(String title, int year) {
        return title + "-" + year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getId() {
        return id;
    }

    public String toString(){
        List<String> listOfActors = getActors().stream().map(actor -> actor.getName()).collect(Collectors.toList());
        return String.format(
                "%s%s%n%s%s%n%s%d%n%s%s%n%s%s%n%s%s%n",
                "Title: ",
                getTitle(),
                "Genre: ",
                getGenre(),
                "Year: ",
                getYear(),
                "ID: ",
                getId(),
                "Director: ",
                getDirector().getName(),
                "List of actors: ",
                listOfActors
        );
    }
}
