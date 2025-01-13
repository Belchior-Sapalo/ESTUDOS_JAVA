package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exercicios.reversedPhrase;

import com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exemplos.EmptyListException;
import com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exemplos.List;

public class Stack <T>{
    private List<T> stackList;

    public Stack(){
        stackList = new List<>();
    }
    public void push(T item){
        stackList.insertAtFront(item);
    }

    public T pop() throws EmptyListException {
        return stackList.removeFromFront();
    }

    public void print(){
        stackList.print();
    }

    public String merge(){
        return stackList.merge();
    }
}
