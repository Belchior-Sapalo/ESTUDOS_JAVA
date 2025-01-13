package com.estudosjava.javacomoprogramar.javacore.capitulo11_Exceptions.exceptions.assertivas;

import java.util.Scanner;

public class AssertTeste {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Insira um numero entre 0 e 10");
        int num = input.nextInt();

        //Assert lanca uma AssertionError se a expressao (num >= 0 && num <= 100) retornar false
        //assert (num >= 0 && num <= 10);

        //Assert lanca uma AssertionError com a mensagem "Number out of range" se a expressao (num >= 0 && num <= 100) retornar false
        assert (num >= 0 && num <= 10) : "bad number: " + num;
        System.out.printf("You entered %d%n", num);
    }
}
