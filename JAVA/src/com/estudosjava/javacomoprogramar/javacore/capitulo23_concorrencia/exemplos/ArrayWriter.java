package com.estudosjava.javacomoprogramar.javacore.capitulo23_concorrencia.exemplos;

public class ArrayWriter implements Runnable{
    private final SimpleArray shiredSimpleArray;
    private final int startValue;

    public ArrayWriter(SimpleArray shiredSimpleArray, int startValue) {
        this.shiredSimpleArray = shiredSimpleArray;
        this.startValue = startValue;
    }

    public void run() {
        for (int i = startValue; i < startValue + 3; i++) {
            shiredSimpleArray.add(i);
        }
    }
}
