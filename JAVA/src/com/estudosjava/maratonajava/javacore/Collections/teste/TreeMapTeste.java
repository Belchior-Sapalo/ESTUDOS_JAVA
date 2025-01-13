package com.estudosjava.maratonajava.javacore.Collections.teste;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapTeste {
    public static void main(String[] args) {
        NavigableMap<String, String> map = new TreeMap<>();
        map.put("A", "val1");
        map.put("B", "val2");
        map.put("C", "val3");
        map.put("E", "val5");
        map.put("D", "val4");


        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
