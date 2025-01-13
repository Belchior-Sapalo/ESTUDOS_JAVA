package com.estudosjava.maratonajava.javacore.Exceptions.assertivas.teste;

public class AssertivasTeste {
    public static void main(String[] args) {
        teste(-20);
    }

    private static void teste(int value){
        assert (value > 0);
    }
}
