package com.estudosjava.exercicios.Library_manager_app.models;

public class BookModel {
    private int id;
    private String title;
    private String author;
    private double price;
    private boolean availability;

    public BookModel(int id, String title, String author, double price, boolean availability) {
        if(price < 0)
            throw new IllegalArgumentException("Price must be a positive number");
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
            throw new IllegalArgumentException("Price must be a positive number");
        this.price = price;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String toString(){
        return String.format("Book: %s, %s: %s de %s, %s: %.2f, %s: %s", this.getId(), "Title", this.getTitle(), this.getAuthor(), "Price", this.getPrice(), "Availability", this.getAvailability());
    }
}
