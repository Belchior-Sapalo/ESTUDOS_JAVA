package com.estudosjava.javacomoprogramar.javacore.capitulo18_recursao.exemplos;

import java.math.BigInteger;

public class Factorial {
    public static long factorial(long number){
        if(number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }

    public static BigInteger factorialBig(BigInteger number){
        if (number.compareTo(BigInteger.ONE) <= 0)
            return BigInteger.ONE;
        else
            return number.multiply(factorialBig(number.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {
        /*for(int i = 0; i <= 21; i++){
            System.out.printf("%d! = %d%n", i, factorial(i));
        }*/

        for (int i = 0; i <= 50; i++) {
            System.out.printf("%d! = %d%n", i, factorialBig(BigInteger.valueOf(i)));
        }
    }
}
