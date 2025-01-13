package com.estudosjava.maratonajava.javacore.JDBC.teste;

import com.estudosjava.maratonajava.javacore.JDBC.classes.Comprador;
import com.estudosjava.maratonajava.javacore.JDBC.database.CompradorDB;

import java.util.Comparator;
import java.util.List;

public class TesteConnection {
    public static void main(String[] args) {
        CompradorDB compradorDB = new CompradorDB();
        compradorDB.findAllCached().forEach(System.out::println);
    }

    public static void show() {
        CompradorDB compradorDB = new CompradorDB();
        List<Comprador> compradorList = compradorDB.findAll();
        Comparator<Comprador> byName = Comparator.comparing(Comprador::getNome);
        compradorList.stream().forEach(System.out::println);
    }
}
