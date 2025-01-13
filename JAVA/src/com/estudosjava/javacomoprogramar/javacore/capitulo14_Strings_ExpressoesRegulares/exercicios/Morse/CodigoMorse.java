package com.estudosjava.javacomoprogramar.javacore.capitulo14_Strings_ExpressoesRegulares.exercicios.Morse;

import java.util.Scanner;

public class CodigoMorse {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("*** Escolha uma opcao ***");
        System.out.println("1. Portugues para Morse");
        System.out.println("2. Morse para Portugues");
        int escolha = entrada.nextInt();
        System.out.println("Insira a palavra ou letra");
        String palavra = entrada.next();
        System.out.printf("%s: %s%n", "Resultado", traduzir(palavra, escolha));


    }

    public static String traduzir(String palavraParaTraduzir, int escolha){
        String[] codigoMorseLetras = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
        String[] codigoMorseNumeros = {"-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."};
        String result = palavraParaTraduzir;
        switch (escolha){
            case 1-> result = palavraParaTraduzir
                    .replaceAll("[aA]", codigoMorseLetras[0])
                    .replaceAll("[bB]", codigoMorseLetras[1])
                    .replaceAll("[cC]", codigoMorseLetras[2])
                    .replaceAll("[dD]", codigoMorseLetras[3])
                    .replaceAll("[eE]", codigoMorseLetras[4])
                    .replaceAll("[fF]", codigoMorseLetras[5])
                    .replaceAll("[gG]", codigoMorseLetras[6])
                    .replaceAll("[hH]", codigoMorseLetras[7])
                    .replaceAll("[iI]", codigoMorseLetras[8])
                    .replaceAll("[jJ]", codigoMorseLetras[9])
                    .replaceAll("[kK]", codigoMorseLetras[10])
                    .replaceAll("[lL]", codigoMorseLetras[11])
                    .replaceAll("[mM]", codigoMorseLetras[12])
                    .replaceAll("[nN]", codigoMorseLetras[13])
                    .replaceAll("[oO]", codigoMorseLetras[14])
                    .replaceAll("[pP]", codigoMorseLetras[15])
                    .replaceAll("[qQ]", codigoMorseLetras[16])
                    .replaceAll("[rR]", codigoMorseLetras[17])
                    .replaceAll("[s|]", codigoMorseLetras[18])
                    .replaceAll("[tT]", codigoMorseLetras[19])
                    .replaceAll("[uU]", codigoMorseLetras[20])
                    .replaceAll("[vV]", codigoMorseLetras[21])
                    .replaceAll("[wW]", codigoMorseLetras[22])
                    .replaceAll("[xX]", codigoMorseLetras[23])
                    .replaceAll("[yY]", codigoMorseLetras[24])
                    .replaceAll("[zZ]", codigoMorseLetras[25])
                    .replaceAll("0", codigoMorseNumeros[0])
                    .replaceAll("1", codigoMorseNumeros[1])
                    .replaceAll("2", codigoMorseNumeros[2])
                    .replaceAll("3", codigoMorseNumeros[3])
                    .replaceAll("4", codigoMorseNumeros[4])
                    .replaceAll("5", codigoMorseNumeros[5])
                    .replaceAll("6", codigoMorseNumeros[6])
                    .replaceAll("7", codigoMorseNumeros[7])
                    .replaceAll("8", codigoMorseNumeros[8])
                    .replaceAll("9", codigoMorseNumeros[9]);
            case 2-> result = palavraParaTraduzir
                    .replaceAll("\\.-", "a")
                    .replaceAll(codigoMorseLetras[1], "b")
                    .replaceAll(codigoMorseLetras[2], "c")
                    .replaceAll(codigoMorseLetras[3], "d")
                    .replaceAll(codigoMorseLetras[4], "e")
                    .replaceAll(codigoMorseLetras[5], "f")
                    .replaceAll(codigoMorseLetras[6], "g")
                    .replaceAll(codigoMorseLetras[7], "h")
                    .replaceAll(codigoMorseLetras[8], "i")
                    .replaceAll(codigoMorseLetras[9], "j")
                    .replaceAll(codigoMorseLetras[10], "k")
                    .replaceAll(codigoMorseLetras[11], "l")
                    .replaceAll(codigoMorseLetras[12], "m")
                    .replaceAll(codigoMorseLetras[13], "n")
                    .replaceAll(codigoMorseLetras[14], "o")
                    .replaceAll(codigoMorseLetras[15], "p")
                    .replaceAll(codigoMorseLetras[16], "q")
                    .replaceAll(codigoMorseLetras[17], "r")
                    .replaceAll(codigoMorseLetras[18], "s")
                    .replaceAll(codigoMorseLetras[19], "t")
                    .replaceAll(codigoMorseLetras[20], "u")
                    .replaceAll(codigoMorseLetras[21], "v")
                    .replaceAll(codigoMorseLetras[22], "w")
                    .replaceAll(codigoMorseLetras[23], "x")
                    .replaceAll(codigoMorseLetras[24], "y")
                    .replaceAll(codigoMorseLetras[25], "z");
        }
        return result;
    }

    public static String traduzir2(String caracter){
        String[] codigoMorseLetras = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
        String res = "";
        if(caracter.equals(codigoMorseLetras[0]))
            res += "a";
        else if(caracter.equals(codigoMorseLetras[1]))
            res += "b";
        else if(caracter.equals(codigoMorseLetras[2]))
            res += "c";
        else if(caracter.equals(codigoMorseLetras[3]))
            res += "d";
        else if(caracter.equals(codigoMorseLetras[4]))
            res += "e";
        else if(caracter.equals(codigoMorseLetras[5]))
            res += "f";
        else if(caracter.equals(codigoMorseLetras[6]))
            res += "g";
        else if(caracter.equals(codigoMorseLetras[7]))
            res += "h";
        else if(caracter.equals(codigoMorseLetras[8]))
            res += "i";
        else if(caracter.equals(codigoMorseLetras[9]))
            res += "j";
        else if(caracter.equals(codigoMorseLetras[10]))
            res += "k";
        if(caracter.equals(codigoMorseLetras[11]))
            res += "l";
        else if(caracter.equals(codigoMorseLetras[12]))
            res += "m";
        else if(caracter.equals(codigoMorseLetras[13]))
            res += "n";
        else if(caracter.equals(codigoMorseLetras[14]))
            res += "o";
        else if(caracter.equals(codigoMorseLetras[15]))
            res += "p";
        else if(caracter.equals(codigoMorseLetras[16]))
            res += "k";
        else if(caracter.equals(codigoMorseLetras[17]))
            res += "r";
        else if(caracter.equals(codigoMorseLetras[18]))
            res += "s";
        else if(caracter.equals(codigoMorseLetras[19]))
            res += "t";
        else if(caracter.equals(codigoMorseLetras[20]))
            res += "u";
        else if(caracter.equals(codigoMorseLetras[21]))
            res += "v";
        else if(caracter.equals(codigoMorseLetras[22]))
            res += "w";
        else if(caracter.equals(codigoMorseLetras[23]))
            res += "x";
        else if(caracter.equals(codigoMorseLetras[24]))
            res += "y";
        else if(caracter.equals(codigoMorseLetras[25]))
            res += "z";
        return res;
    }
}
