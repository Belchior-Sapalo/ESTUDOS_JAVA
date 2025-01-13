package com.estudosjava.maratonajava.javacore.Exceptions.tryWithResource.classes;

public class Leitor1 implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Fechando leitor 1");
    }

    public void reading() throws Exception{
        System.out.println("Lendo arquivo 1");
    }
}
