package com.estudosjava.javacomoprogramar.javacore.capitulo14_Strings_ExpressoesRegulares.ExpressoesRegulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncontrarUsandoRegxTeste {
    public static void main(String[] args) {
        String regex = "(.-)+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("file.-.---png file.jpeg file1.txt file2.txt file1.jpeg file3.txt");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
