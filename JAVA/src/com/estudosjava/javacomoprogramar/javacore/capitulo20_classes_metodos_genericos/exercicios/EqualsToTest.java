package com.estudosjava.javacomoprogramar.javacore.capitulo20_classes_metodos_genericos.exercicios;

public class EqualsToTest {
    public static void main(String[] args) {
        System.out.println(isEqualTo(20, 20));
    }

    public static <T extends Comparable<T>> boolean isEqualTo(T a, T b) {
        return a.equals(b);
    }
}
