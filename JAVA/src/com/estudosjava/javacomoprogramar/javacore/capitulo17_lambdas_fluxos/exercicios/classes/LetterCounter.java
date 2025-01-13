package com.estudosjava.javacomoprogramar.javacore.capitulo17_lambdas_fluxos.exercicios.classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LetterCounter {
    public static void main(String[] args) throws IOException {
       Map<Character, Long> counter = Files.lines(Paths.get("Chapter2Paragraph.txt"))
                .map(line -> line.replaceAll("(?!')\\p{P}", ""))
                .map(line -> line.replaceAll("\\s", ""))
                .map(String::toCharArray)
                .flatMap(array -> IntStream.range(0, array.length).mapToObj(i -> array[i]))
               .collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
       counter.forEach((key, value) -> System.out.println(key + " : " + value));

    }
}
