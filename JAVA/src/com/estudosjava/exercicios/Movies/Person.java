package com.estudosjava.exercicios.Movies;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        if(birthYear <= 0)
            throw new IllegalArgumentException("Birth year cannot be negative");
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        if(birthYear <= 0)
            throw new IllegalArgumentException("Birth year cannot be negative");
        this.birthYear = birthYear;
    }

    public String toString(){
        return String.format("Name: %s%nBirth year: %d", name, birthYear);
    }
}
