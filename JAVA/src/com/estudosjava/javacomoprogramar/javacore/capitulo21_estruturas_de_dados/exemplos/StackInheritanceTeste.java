package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exemplos;

public class StackInheritanceTeste {
    public static void main(String[] args) {
        StackComposition<Integer> stack = new StackComposition<>();
        stack.push(-1);
        stack.print();
        stack.push(0);
        stack.print();
        stack.push(1);
        stack.print();
        stack.push(5);
        stack.print();
        try{
            int removed;

            while (true){
                removed = stack.pop();
                System.out.printf("%n%d popped%n", removed);
                stack.print();
            }
        }catch (EmptyListException e){
            e.printStackTrace();
        }
    }
}
