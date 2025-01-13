package com.estudosjava.maratonajava.javacore.String;

public class StringTeste {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        performanceString(200000);
        long fim = System.currentTimeMillis();

        System.out.println("Tempo gasto String: " + (fim - inicio) + " ms");

        long inicio1 = System.currentTimeMillis();
        performanceStringBuilder(2000000);
        long fim1 = System.currentTimeMillis();

        System.out.println("Tempo gasto StringBuilder: " + (fim1 - inicio1) + " ms");

        long inicio2 = System.currentTimeMillis();
        performanceStringBuffer(2000000);
        long fim2 = System.currentTimeMillis();

        System.out.println("Tempo gasto StringBuffer: " + (fim2 - inicio2) + " ms");
    }

    private static void performanceString(int tam){
        String s = "";
        for(int i = 0; i < tam; i++){
            s = s + i;
        }
    }

    private static void performanceStringBuilder(int tam){
        StringBuilder s = new StringBuilder(tam);
        for(int i = 0; i < tam; i++){
            s.append(i);
        }
    }

    private static void performanceStringBuffer(int tam){
        StringBuffer s = new StringBuffer(tam);
        for(int i = 0; i < tam; i++){
            s.append(i);
        }
    }
}
