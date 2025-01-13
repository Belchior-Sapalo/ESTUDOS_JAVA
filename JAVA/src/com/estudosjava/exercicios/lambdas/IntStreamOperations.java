package com.estudosjava.exercicios.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class IntStreamOperations {
    public static void main(String[] args) {
        Integer[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

        System.out.println(Arrays.stream(values).toList());
        Predicate<Integer> greter = value -> value > 4;

        System.out.println(Arrays.stream(values).filter(greter).sorted().toList());

    }

    public static  int max(int[] a){
        int max = 0;
        for(int i = 0; i < a.length; i++){
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }
}
