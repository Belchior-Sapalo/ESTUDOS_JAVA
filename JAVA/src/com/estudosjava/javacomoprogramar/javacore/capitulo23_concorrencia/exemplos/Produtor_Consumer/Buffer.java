package com.estudosjava.javacomoprogramar.javacore.capitulo23_concorrencia.exemplos.Produtor_Consumer;

public interface Buffer {
    public void blokingPut(int value) throws InterruptedException;
    public int blokingGet() throws InterruptedException;
}
