package com.estudosjava.javacomoprogramar.javacore.capitulo17_lambdas_fluxos.classes;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringStream {
    public static void main(String[] args) {
        String[] colors = {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

        System.out.printf("Original strings: %s%n", Arrays.asList(colors));

        System.out.printf("strings in uppercase: %s%n", Arrays.stream(colors).map(String::toUpperCase).collect(Collectors.toList()));

        System.out.printf("strings greater than m sorted ascending: %s%n",  Arrays.stream(colors).filter(s -> s.compareToIgnoreCase("n") < 0).sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList()));
        System.out.printf("strings greater than m sorted descending: %s%n",  Arrays.stream(colors).filter(s -> s.compareToIgnoreCase("n") < 0).sorted(String.CASE_INSENSITIVE_ORDER.reversed()).collect(Collectors.toList()));
    }
}
