package com.estudosjava.javacomoprogramar.javacore.capitulo20_classes_metodos_genericos.exemplos;

public class GenericMrthodTest {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        String[] stringArray = {"one", "two", "three", "four", "five", "six", "seven", "eight"};

        printArrat(stringArray);
    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static <T> void printArray(T[] array, int limiteInferior, int limiteSuperior) {
        if(limiteInferior < 0 || limiteSuperior > array.length)
            throw new InvalidSubscriptException();
        for(int i = limiteInferior; i <= limiteSuperior; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void printArrat(String[] array) {
        System.out.println("Array stringArray contains: ");
        for (int i = 0; i < array.length; i++){
            if(i == 4)
                System.out.println();
            System.out.printf("%s  ", array[i]);
        }
    }
}
