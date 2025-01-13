package com.estudosjava.javacomoprogramar.javacore.capitulo20_classes_metodos_genericos.exemplos;

import java.util.ArrayList;

public class TotalNumbers {
    public static void main(String[] args) {
        Number[] numbers = {1, 2.4, 3, 4.1}; // Integers e Doubles
        ArrayList<Number> numberList = new ArrayList<>();

        for (Number number : numbers) {
            numberList.add(number);
        }

        System.out.printf("numberList contains: %s%n", numberList);
        System.out.printf("Total of the elements in numberList: %.1f%n", sum(numberList));
    }

    public static double sum(ArrayList<Number> numbers){
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}
