package com.estudosjava.maratonajava.javacore.Exceptions.tryWithResource.classes;

public class Leitor2 implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Fechando leitor 2");
    }

    public void reading() throws Exception{
        System.out.println("Lendo arquivo 2");
    }
}
