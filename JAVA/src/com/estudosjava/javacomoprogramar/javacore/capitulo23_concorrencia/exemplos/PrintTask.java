package com.estudosjava.javacomoprogramar.javacore.capitulo23_concorrencia.exemplos;

import java.security.SecureRandom;

public class PrintTask implements Runnable {
    private static SecureRandom generator = new SecureRandom();
    private final int sleepTime;
    private final String taskName;

    public PrintTask(String taskName) {
        this.taskName = taskName;
        this.sleepTime = generator.nextInt(5000);
    }

    public void run() {
        try{ // coloca a thread para dormir pela quantidade de tempo sleepTime
            System.out.printf("%s going to sleep for %d milliseconds.%n", taskName, sleepTime);
            Thread.sleep(sleepTime);// coloca a thread para dormir
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt(); // reinterrompe a thread
        }
        System.out.printf("%s done sleeping%n", taskName);
    }
}
