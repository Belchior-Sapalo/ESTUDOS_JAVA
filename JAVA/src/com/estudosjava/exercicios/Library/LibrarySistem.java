package com.estudosjava.exercicios.Library;

public class LibrarySistem {
    public static void main(String[] args) {
        Biblioteca library = new Biblioteca();
        Livro livro = new Livro("L01", "Amor", ItemStatus.DISPONIVEL, "Belchior");
        DVDS dvd = new DVDS("D01", "Meu Rap", ItemStatus.DISPONIVEL, 10);
        Revista revista = new Revista("R01", "Luanda", ItemStatus.DISPONIVEL, 2024);
    }
}
