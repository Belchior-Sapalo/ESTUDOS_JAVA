package com.estudosjava.javacomoprogramar.javacore.capitulo17_lambdas_fluxos.exercicios.classes;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AleatoryStream {
    public static void main(String[] args) {
        Character[] array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z'
        };
        SecureRandom random = new SecureRandom();
        Character[] letras = new Character[30];
        for (int i = 0; i < letras.length; i++) {
            letras[i] = array[random.nextInt(array.length)];
        }
        List<Character> list = new ArrayList<>(Arrays.asList(letras));

        System.out.printf("Lista original: %s",list);

        System.out.println();
        System.out.print("Lista ordeda: ");
        list.stream().map(character -> character.toString()).sorted(String.CASE_INSENSITIVE_ORDER).forEach(word -> System.out.print(word + " "));
        System.out.println();
        System.out.print("Lista ordeda de forma descrescente: ");
        list.stream().map(character -> character.toString()).sorted(String.CASE_INSENSITIVE_ORDER.reversed()).forEach(word -> System.out.print(word + " "));
        System.out.println();
        System.out.print("Lista ordenada de forma crescente sem duplicates: ");
        list.stream().distinct().map(character -> character.toString()).sorted(String.CASE_INSENSITIVE_ORDER).forEach(word -> System.out.print(word + " "));
        System.out.println();

    }
}
