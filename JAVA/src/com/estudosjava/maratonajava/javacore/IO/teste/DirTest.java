package com.estudosjava.maratonajava.javacore.IO.teste;

import java.io.File;
import java.io.IOException;

public class DirTest {
    public static void main(String[] args) throws IOException {
        File dir = new File("folder");
        File arquivo = new File(dir,"arquivo2.txt");
        verArquivos();
    }

    public static void verArquivos(){
        File file = new File("folder");
        String[] files = file.list();
        for(String fileName : files){
            System.out.println(fileName);
        }
    }
}
