package com.estudosjava.javacomoprogramar.javacore.capitulo23_concorrencia.exemplos.Produtor_Consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlokingBufferTeste {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Buffer sharedLocation = new BlokingBuffer();
        executorService.execute(new Producer(sharedLocation));
        executorService.execute(new Consumer(sharedLocation));
        executorService.shutdown();

        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
