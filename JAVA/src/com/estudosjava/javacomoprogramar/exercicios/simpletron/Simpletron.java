package com.estudosjava.javacomoprogramar.exercicios.simpletron;

import java.util.Scanner;

/*
* final int READ = 10; Lê uma palavra do teclado para uma posição específica da memória.
* final int WRITE = 11; Escreve na tela uma palavra de uma posição específica da memória.
* final int LOAD = 20; Carrega uma palavra de uma posição específica na memória para o acumulador
* final int STORE = 21; Armazena uma palavra do acumulador para uma posição específica na memória.
* final int ADD = 30; Adiciona uma palavra de uma posição específica na memória à palavra no acumulador (resultados no acumulador)
* final int SUBTRACT = 31; Subtrai uma palavra de uma posição específica na memória da palavra no acumulador (resultados no acumulador)
* final int DIVIDE = 32; Divide uma palavra de uma posição específica na memória da palavra no acumulador
* final int MULTIPLY = 33; Multiplica uma palavra de uma posição específica na memória pela palavra no acumulador
* final int BRANCH = 40; Desvia para uma posição específica na memória.
* final int BRANCHNEG = 41; Desvia para uma posição específica na memória se o acumulador for negativo.
* final int BRANCHZERO = 42; Desvia para uma posição específica na memória se o acumulador for zero.
* final int HALT = 43; Pare. O programa completou sua tarefa.
*/
public class Simpletron {
    public static void main(String[] args) {
        System.out.println("*** Welcome to Simpletron! ***");
        System.out.println("*** Please enter your program one instruction! ***");
        System.out.println("*** (or data word) at a time. I will display ***");
        System.out.println("*** the location number and a question mark (?). ***");
        System.out.println("*** You then type the word for that location. ***");
        System.out.println("*** Type -888 to stop entering your program. ***");
        System.out.println();

        Scanner input = new Scanner(System.in);
        int[] memory = new int[100];
        int operationCode;
        int instructionCounter = 0;
        do{
            System.out.printf("%02d %s", instructionCounter, "? ");
            operationCode = input.nextInt();
            while ((operationCode < -9999 || operationCode > 9999) && operationCode != -99999){
                System.out.println("Operation code must be betwen -9999 and 9999");
                System.out.printf("%02d %s", instructionCounter, "?");
                operationCode = input.nextInt();
            }
            if(operationCode != -99999){
                memory[instructionCounter] = operationCode;
                instructionCounter++;
            }
        }while (operationCode != -99999);
        execution(operationCode, instructionCounter, memory);

    }

    public static void execution(int operationCode, int instructionCounter, int[] memory){
        System.out.println("*** Program loading completed ***");
        System.out.println("*** Program execution begins ***");
        int operand;
        int instructionRegister;
        int accumulator = 0;
        for(int i = 0; i < instructionCounter; i++){
            instructionRegister = memory[i];
            operationCode = instructionRegister / 100;
            operand = instructionRegister % 100;
            switch (operationCode){
                case 10 ->{
                    Scanner input = new Scanner(System.in);
                    System.out.println("Type the value for the operation");
                    memory[operand] = input.nextInt();
                }
                case 11 ->{
                    System.out.printf("%s %02d%n", "The result of operation is", memory[operand]);
                }
                case 20 ->{
                    accumulator = memory[operand];
                }
                case 21 ->{
                    memory[operand] = accumulator;
                }
                case 30 ->{
                    accumulator += memory[operand];
                }
                case 31 ->{
                    accumulator -= memory[operand];
                }
                case 32 ->{
                    accumulator /= memory[operand];
                }
                case 33 ->{
                    accumulator *= memory[operand];
                }
                case 43 ->{
                    System.out.println("*** Simpletron execution terminated ***");
                }
            }
        }
    }

}
