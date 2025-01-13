package com.estudosjava.javacomoprogramar.javacore.capitulo17_lambdas_fluxos.classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileStream {
    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("\\s+");

        // conta ocorrências de cada palavra em um Stream<String> classificado por palavra
        Map<String, Long> wordCount =
                Files.lines(Paths.get("Chapter2Paragraph.txt"))
                        .map(line -> line.replaceAll("(?!')\\p{P}", ""))
                        .flatMap(line -> pattern.splitAsStream(line))
                        .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));

        // exibe as palavras agrupadas pela letra inicial
       wordCount.entrySet()
                .stream()
                .collect(Collectors.groupingBy(entry -> entry.getKey().charAt(0),TreeMap::new, Collectors.toList()))
                        .forEach((letter, wordList) -> {
                            System.out.printf("%n%C%n", letter);
                            wordList.stream().forEach(word -> System.out.printf("%13s: %d%n", word.getKey(), word.getValue()));
                        });


    }
}
