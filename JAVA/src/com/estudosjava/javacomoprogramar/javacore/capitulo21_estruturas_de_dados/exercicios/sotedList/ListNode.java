package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exercicios.sotedList;

public class ListNode<T extends Comparable<T>>{
    private T data;
    private ListNode<T> next;
    private ListNode<T> previous;

    public ListNode(T data) {
        this(null, data, null);
    }

    public ListNode(ListNode<T> previous, T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode<T> previous) {
        this.previous = previous;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

}
