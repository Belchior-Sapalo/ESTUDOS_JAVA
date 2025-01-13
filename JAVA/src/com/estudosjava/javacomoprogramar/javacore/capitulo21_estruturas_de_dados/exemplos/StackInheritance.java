package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exemplos;

public class StackInheritance<T> extends List<T> {
    public StackInheritance() {
        super("Stack");
    }

    public void push(T object){
        insertAtFront(object);
    }

    public T pop(){
        return removeFromFront();
    }
}
