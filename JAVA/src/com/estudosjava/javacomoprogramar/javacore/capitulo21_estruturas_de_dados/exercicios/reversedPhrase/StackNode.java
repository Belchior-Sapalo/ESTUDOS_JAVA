package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exercicios.reversedPhrase;

public class StackNode<T>{
    private T item;
    private StackNode<T> next;

    public StackNode(T item){
        this(item, null);
    }

    public StackNode(T item, StackNode<T> next){
        this.item = item;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }
}
