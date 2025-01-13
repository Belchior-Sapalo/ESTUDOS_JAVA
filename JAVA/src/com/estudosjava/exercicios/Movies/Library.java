package com.estudosjava.exercicios.Movies;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library {
    private static final String PATH = "movies.ser";
    List<Film> films;

    public Library() {
        films = new ArrayList<>();
    }

    public void addFilm(Film film) throws MovieAlreadyExistsException{
        for (Film f : films) {
            if (f.getId().equals(film.getId()))
                throw new MovieAlreadyExistsException();
        }
        films.add(film);
    }

    public void getFilms() {
        System.out.println("Films List: ");
        if (films.isEmpty())
            System.out.println("List is empty");
        else
        films.forEach(film -> System.out.println(film));
    }

    public void removeFilm(String id) {
        boolean removed  = films.removeIf(film -> film.getId().equals(id));
        if (!removed)
            System.out.println("Film not found");
        else
            System.out.println("Film removed");
    }

    public void saveListOfMoviesToFile(){
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(PATH))){
            writer.writeObject(films);
            System.out.println("List of movies saved to " + PATH);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadListOfMoviesFromFile() {
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(PATH))){
            films = (List<Film>) reader.readObject();
            System.out.println("List of movies read from " + PATH);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Film> search(String keyWord) {
        Predicate<Film> searscPedicate = film -> film.getTitle().equals(keyWord) || film.getDirector().getName().equals(keyWord) || film.getId().equals(keyWord);
        List<Film> result = films.stream().filter(searscPedicate).collect(Collectors.toList());
        return result;
    }

    public void sort(){
        films = films.stream().sorted(Comparator.comparing(Film::getTitle)).collect(Collectors.toList());
    }
}
