package com.estudosjava.maratonajava.javacore.Collections.teste;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTeste {
    public static void main(String[] args) {
        Queue<String> stringQueue  = new PriorityQueue<>();
        stringQueue.add("A");
        stringQueue.add("B");
        stringQueue.add("D");
        stringQueue.add("E");
        stringQueue.add("C");
        System.out.println(stringQueue);
    }
}
