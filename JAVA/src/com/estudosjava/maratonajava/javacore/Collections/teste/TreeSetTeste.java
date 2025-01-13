package com.estudosjava.maratonajava.javacore.Collections.teste;

import com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.classes.Invoice;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetTeste {
    public static void main(String[] args) {
        Invoice i1 = new Invoice("83", 7, "Electric sander", 57.98);
        Invoice i2 = new Invoice("24", 18, "Electric sander", 99.99);
        Invoice i3 = new Invoice("7", 11, "Sledge hammer", 21.50);
        Invoice i4 = new Invoice("77", 76, "Hammer", 11.99);
        Invoice i5 = new Invoice("39", 3, "Lawn mower", 79.50);
        Invoice i6 = new Invoice("68", 106, "Screwdriver", 6.99);

        NavigableSet<Invoice> invoiceNavigableSet = new TreeSet<Invoice>();

    }
}
