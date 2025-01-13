package com.estudosjava.exercicios.Library;

public class Livro extends ItemLibrary{
    private String autor;

    public Livro(String id, String titulo, ItemStatus status, String autor) {
        super(id, titulo, status);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString(){
        return String.format(
                "%s%n%s: %s%n",
                super.toString(),
                "Autor",
                getAutor()
        );
    }
}
