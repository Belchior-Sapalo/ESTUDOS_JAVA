package com.estudosjava.javacomoprogramar.javacore.capitulo23_concorrencia.exemplos.Produtor_Consumer;

import java.util.concurrent.ArrayBlockingQueue;

public class BlokingBuffer implements Buffer{
    private final ArrayBlockingQueue<Integer> buffer;

    public BlokingBuffer() {
        buffer = new ArrayBlockingQueue<>(1);
    }

    @Override
    public void blokingPut(int value) throws InterruptedException {
        buffer.put(value);
        System.out.printf("%s%2d\t%s%d%n", "Producer writes ", value, "Buffer cells occupied: ", buffer.size());
    }

    @Override
    public int blokingGet() throws InterruptedException {
        int readValue = buffer.take();
        System.out.printf("%s %2d\t%s%d%n", "Consumer reads ",readValue, "Buffer cells occupied: ", buffer.size());

        return readValue;
    }
}
