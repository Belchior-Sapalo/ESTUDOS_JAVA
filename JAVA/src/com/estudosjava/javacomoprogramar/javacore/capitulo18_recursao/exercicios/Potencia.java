package com.estudosjava.javacomoprogramar.javacore.capitulo18_recursao.exercicios;

public class Potencia {
    public static long power(int base, int exponent) {
        if(exponent == 1)
            return base;
        else if(exponent == 0)
            return 1;
        else
            return base * power(base, exponent - 1);
    }

    public static int gcd(int x, int y){
        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
    }

    public static void main(String[] args) {
        System.out.println(gcd(8, 4));
    }
}
