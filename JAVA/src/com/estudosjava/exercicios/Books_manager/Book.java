package com.estudosjava.exercicios.Books_manager;

import java.io.Serializable;

public class Book implements Serializable {
    private int id;
    private String title;
    private String author;
    private double price;

    public Book(int id, String title, String author, double price) {
        if(price < 0)
            throw new IllegalArgumentException("O preco deve ser maior ou igual a zero");
        if(id < 0)
            throw new IllegalArgumentException("O id deve ser maior ou igual a zero");
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void setId(int id) {
        if(id < 0)
            throw new IllegalArgumentException("O id deve ser maior ou igual a zero");
        this.id = id;
    }

    public int getId() {
        return id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0)
            throw new IllegalArgumentException("O preco deve ser maior ou igual a zero");
        this.price = price;
    }

    public String toString(){
        return String.format("Livro: %d, %s de %s, preco: %.2f", getId(), getTitle(), getAuthor(), getPrice());
    }
}
