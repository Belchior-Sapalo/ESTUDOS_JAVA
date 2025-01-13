package com.estudosjava.javacomoprogramar.javacore.capitulo20_classes_metodos_genericos.exemplos;

public class StackTest {
    public static void main(String[] args) {
        Double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5};
        Integer[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Pilha de tipos brutos atribuídos à classe Stack da variável de tipos brutos
        Stack rawTypeStack1 = new Stack(5);

        // Stack <Double> atribuído à Stack da variável de tipos brutos
        Stack rawTypeStack2 = new Stack<Double>();

        // Pilha dos tipos brutos atribuídos à variável Stack<Integer>ÿ
        Stack<Integer> integerStack = new Stack(10);

        testPush("rawTypeStack1", rawTypeStack1, doubleElements);
        testPop("rawTypeStack1", rawTypeStack1);
        testPush("rawTypeStack2", rawTypeStack2, doubleElements);
        testPop("rawTypeStack2", rawTypeStack2);
        testPush("integerStack", integerStack, integerElements);
        testPop("integerStack", integerStack);
    }

    //Generico
    public static <T> void testPush(String name,Stack<T> stack, T[] elements) {
        System.out.printf("%nPushing elements onto %s%n", name);
        for(T element : elements) {
            System.out.printf("%s ", element);
            stack.push(element);
        }
    }

    //Generico
    public static <T> void testPop(String name, Stack<T> stack) {
        try{
            System.out.printf("%nPopping elements from %s%n", name);
            T popValue;

            while(true){
                popValue = stack.pop();
                System.out.printf("%s ", popValue);
            }
        }catch (EmptyStackException e){
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    public static void testPushDouble(Stack<Double> stack, double[] doubleElements) {
        System.out.printf("%nPushing elements onto doubleStack%n");
        for (double d : doubleElements) {
            System.out.printf("%.1f ", d);
            stack.push(d);
        }
    }

    public static void testPopDouble(Stack<Double> stack) {
        try{
            System.out.printf("%nPopping elements from doubleStack%n");
            double popValue;

            while (true){
                popValue = stack.pop();
                System.out.printf("%.1f ", popValue);
            }
        }catch (EmptyStackException e){
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    public static void testPushInteger(Stack<Integer> stack, int[] integerElements) {
        System.out.printf("%nPushing elements onto integerStack%n");
        for (int i : integerElements) {
            System.out.printf("%d ", i);
            stack.push(i);
        }
    }

    public static void testPopInteger(Stack<Integer> stack) {
        try{
            System.out.printf("%nPopping elements from integerStack%n");
            int popValue;

            while (true){
                popValue = stack.pop();
                System.out.printf("%d ", popValue);
            }
        }catch (EmptyStackException e){
            System.out.println();
            System.out.println(e.getMessage());
        }
    }
}
