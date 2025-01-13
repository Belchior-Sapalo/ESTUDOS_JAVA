package com.estudosjava.javacomoprogramar.javacore.capitulo20_classes_metodos_genericos.exemplos;

import java.util.ArrayList;

public class CuringasTest {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5};
        ArrayList<Integer> integerList = new ArrayList<>();

        for (Integer integer : integers) {
            integerList.add(integer);
        }

        System.out.printf("integerList contains: %s%n", integerList);
        System.out.printf("Total of the elements in integerList: %.1f%n", sum(integerList));

        Double[] doubles = {1.1, 3.3, 5.5};
        ArrayList<Double> doubleList = new ArrayList<>();

        for (Double d : doubles) {
            doubleList.add(d);
        }

        System.out.printf("integerList contains: %s%n", doubleList);
        System.out.printf("Total of the elements in doubleList: %.1f%n", sum(doubleList));

        Number[] numbers = {1, 2.4, 3, 4.1};
        ArrayList<Number> numbersList = new ArrayList<>();

        for (Number n : numbers) {
            numbersList.add(n);
        }

        System.out.printf("integerList contains: %s%n", numbersList);
        System.out.printf("Total of the elements in numbersList: %.1f%n", sum(numbersList));
    }

    public static double sum(ArrayList<? extends Number> numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}
