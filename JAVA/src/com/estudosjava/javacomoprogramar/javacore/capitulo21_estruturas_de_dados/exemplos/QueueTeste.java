package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exemplos;

public class QueueTeste {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(-1);
        queue.printQueue();
        queue.enqueue(0);
        queue.printQueue();
        queue.enqueue(1);
        queue.printQueue();
        queue.enqueue(5);
        queue.printQueue();

        try {
            int removed;

            while (true){
                removed = queue.dequeue();
                System.out.printf("%n%d dequeued%n", removed);
                queue.printQueue();
            }
        }catch (EmptyListException e){
            e.printStackTrace();
        }
    }
}
