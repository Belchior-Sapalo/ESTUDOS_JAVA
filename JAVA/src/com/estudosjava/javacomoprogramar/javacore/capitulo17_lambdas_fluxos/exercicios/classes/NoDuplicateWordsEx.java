package com.estudosjava.javacomoprogramar.javacore.capitulo17_lambdas_fluxos.exercicios.classes;

import java.util.Arrays;
import java.util.Scanner;

public class NoDuplicateWordsEx {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira uma frase");
        String frase = input.nextLine();

        String[] wordsArray = frase.split(" ");
        System.out.print("As palavras unicas sao: ");
        Arrays.stream(wordsArray).distinct().sorted(String.CASE_INSENSITIVE_ORDER).forEach(word -> System.out.printf("%s%s ", word, ","));
    }
}
