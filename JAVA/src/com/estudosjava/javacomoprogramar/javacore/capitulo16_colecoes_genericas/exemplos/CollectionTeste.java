package com.estudosjava.javacomoprogramar.javacore.capitulo16_colecoes_genericas.exemplos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionTeste {
    public static void main(String[] args) {
        String[] colors = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN"};
        List<String> list = new ArrayList<>();

        for(String color: colors){
            list.add(color);
        }

        String[] removeColors = {"RED", "WHITE", "BLUE"};
        List<String> removeList = new ArrayList<>();

        for(String color: removeColors){
            removeList.add(color);
        }

        System.out.println("ArrayList: ");

        for(int i = 0; i < list.size(); i++){
            System.out.printf("%s ", list.get(i));
        }

        removeColors(list, removeList);
        System.out.printf("%n%nArrayList after calling removeColors:%n");

        for(String color: list){
            System.out.printf("%s ", color);
        }
    }

    public static void removeColors(Collection<String> col1, Collection<String> col2){
        Iterator<String> iterator = col1.iterator();


        while (iterator.hasNext()){
            if(col2.contains(iterator.next()))
                iterator.remove();
        }
    }
}
