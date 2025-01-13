package com.estudosjava.javacomoprogramar.javacore.capitulo16_colecoes_genericas.exemplos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UnsignToArray {
    public static void main(String[] args) {
        String[] colors = {"black", "blue", "yellow"};
        LinkedList<String> links =  new LinkedList<>(Arrays.asList(colors));
        links.addLast("red"); // adiciona como o último item
        links.add("pink"); // adiciona ao final
        links.add(3, "green"); // adiciona no terceiro índice
        links.addFirst("cyan"); // adiciona como primeiro item

        colors = links.toArray(new String[links.size()]);
        System.out.println("colors: ");

        for(String color : colors){
            System.out.println(color);
        }
    }
}
