package com.estudosjava.javacomoprogramar.javacore.capitulo14_Strings_ExpressoesRegulares.Strings;

public class Teste {
    public static void main(String[] args) {
        char[] charArray = new char[5];
        String s1 = "Hello World";

        System.out.printf("s1: %s%n", s1);
        System.out.printf("Length of s1: %d%n", s1.length());
        System.out.printf("The string reverse is: %n");

        for(int i = s1.length() - 1; i >= 0; i--)
            System.out.printf("%c ", s1.charAt(i));

        //Copia caracteres de uma string para um charArray
        s1.getChars(0, 5, charArray, 0);
        System.out.printf("%nThe character array is: ");
        for(char c : charArray){
            System.out.print(c);
        }
    }
}
