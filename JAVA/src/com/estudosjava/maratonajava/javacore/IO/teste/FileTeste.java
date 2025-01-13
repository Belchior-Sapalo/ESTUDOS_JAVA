package com.estudosjava.maratonajava.javacore.IO.teste;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTeste {
    public static void main(String[] args) {
        File file = new File("Arquivo.txt");
        try(FileWriter fw = new FileWriter(file); FileReader fr = new FileReader(file);){
            fw.write("Escrevendo no arquivo\nE saltando uma linha");
            fw.flush();
            fw.close();

            char[] in = new char[500];

            int size = fr.read(in);
            for(int i = 0; i < size; i++){
                System.out.print(in[i]);
            }
            fr.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
