package com.estudosjava.maratonajava.javacore.Collections.teste;

import com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.classes.Invoice;

import java.util.*;

public class BinarySearchTeste {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(20);
        numbers.add(2);
        numbers.add(8);
        numbers.add(4);
        numbers.add(7);
        numbers.add(6);
        Collections.sort(numbers);

        Invoice i1 = new Invoice("83", 7, "Electric sander", 57.98);
        Invoice i2 = new Invoice("24", 18, "Electric sander", 99.99);
        Invoice i3 = new Invoice("7", 11, "Sledge hammer", 21.50);
        Invoice i4 = new Invoice("77", 76, "Hammer", 11.99);
        Invoice i5 = new Invoice("39", 3, "Lawn mower", 79.50);
        Invoice i6 = new Invoice("68", 106, "Screwdriver", 6.99);

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(i1);
        invoices.add(i2);
        invoices.add(i3);
        invoices.add(i4);
        invoices.add(i5);
        invoices.add(i6);

        Comparator<Invoice> byDescription = Comparator.comparing(Invoice::getPartDescription);
        Collections.sort(invoices, byDescription);

        Iterator<Invoice> iterator = invoices.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
        }
    }
}
