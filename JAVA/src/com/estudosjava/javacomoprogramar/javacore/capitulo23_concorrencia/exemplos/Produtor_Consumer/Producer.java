package com.estudosjava.javacomoprogramar.javacore.capitulo23_concorrencia.exemplos.Produtor_Consumer;

import java.security.SecureRandom;

public class Producer implements Runnable{
    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation;

    public Producer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    public void run() {
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            try{
                Thread.sleep(generator.nextInt(3000));
                sharedLocation.blokingPut(i);
                sum += i;
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        System.out.printf("Producer done producing%nTerminating Producer%n");
    }
}
