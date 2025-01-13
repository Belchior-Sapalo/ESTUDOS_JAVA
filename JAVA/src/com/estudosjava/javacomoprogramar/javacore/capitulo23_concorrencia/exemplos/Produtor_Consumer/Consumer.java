package com.estudosjava.javacomoprogramar.javacore.capitulo23_concorrencia.exemplos.Produtor_Consumer;

import java.security.SecureRandom;

public class Consumer implements Runnable{
    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation;

    public Consumer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    public void run(){
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            try{
                Thread.sleep(generator.nextInt(3000));
                sum += sharedLocation.blokingGet();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        System.out.printf("%n%s %d%n%s%n", "Consumer read values totaling", sum, "Terminating Consumer");
    }
}
