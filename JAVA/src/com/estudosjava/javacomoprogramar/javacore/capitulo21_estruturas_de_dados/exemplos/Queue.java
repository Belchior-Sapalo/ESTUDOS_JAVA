package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exemplos;

public class Queue<T>{
    private List<T> queueList;

    public Queue() {
        queueList = new List<>("Queue");
    }

    public void enqueue(T object) {
        queueList.insertAtBack(object);
    }

    public T dequeue() throws EmptyListException{
        return queueList.removeFromFront();
    }

    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    public void printQueue() {
        queueList.print();
    }
}
