package com.estudosjava.exercicios.Library2;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private String ISBN;
    private int year;

    public Book(String title, String author, String ISBN, int year) {
        if(year <= 0)
            throw new IllegalArgumentException("Year must be a positive integer");
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return String.format(
                "%s: %s%n%s: %s%n%s: %s%n%s: %d%n",
                "Autor",
                getAuthor(),
                "Titulo",
                getTitle(),
                "ISBN",
                getISBN(),
                "Ano",
                getYear()
        );
    }
}
