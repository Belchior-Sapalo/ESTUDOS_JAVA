package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exercicios.reversedPhrase;

import java.util.Scanner;

public class ReverseTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        System.out.println("Insira uma frase");
        String frase = sc.nextLine();

        String replaced = frase.replaceAll("[\\p{Punct}\\s]", "");

        char[] charArray = replaced.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            stack.push(String.valueOf(charArray[i]));
        }


        String reversed = stack.merge();
        System.out.println("Frase: " + frase);
        System.out.println("Replaced: " + replaced);
        System.out.println("Reverse: " + reversed);
        if (reversed.equals(replaced))
            System.out.println("A frase e palindroma");
    }
}
