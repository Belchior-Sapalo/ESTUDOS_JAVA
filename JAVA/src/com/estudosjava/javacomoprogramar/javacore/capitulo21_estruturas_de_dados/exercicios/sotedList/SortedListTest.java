package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exercicios.sotedList;

import java.security.SecureRandom;

public class SortedListTest {
    public static void main(String[] args) {
        SortedList<Integer> list = new SortedList<>();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i <= 25; i++) {
            int randomInt = 1 + random.nextInt(100);
            list.insert(randomInt);
        }

        list.print();
    }
}
