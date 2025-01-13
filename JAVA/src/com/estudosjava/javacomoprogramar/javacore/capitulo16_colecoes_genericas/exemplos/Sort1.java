package com.estudosjava.javacomoprogramar.javacore.capitulo16_colecoes_genericas.exemplos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort1 {
    public static void main(String[] args) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        List<String> list = Arrays.asList(suits);

        System.out.printf("Unsorted array elements: %s%n", list);
        Collections.sort(list);
        System.out.printf("Sorted array elements: %s%n", list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.printf("Sorted recerse array elements: %s%n", list);
    }
}
