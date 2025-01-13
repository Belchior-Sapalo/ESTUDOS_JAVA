package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exemplos;

import java.util.EmptyStackException;

public class StackComposition<T>{
    private List<T> stackList;

    public StackComposition() {
        stackList = new List<T>("Stack");
    }

    public void push(T object) {
        stackList.insertAtFront(object);
    }

    public T pop() throws EmptyStackException {
        return stackList.removeFromFront();
    }

    public boolean isEmpty(){
        return stackList.isEmpty();
    }

    public void print(){
        stackList.print();
    }
}
