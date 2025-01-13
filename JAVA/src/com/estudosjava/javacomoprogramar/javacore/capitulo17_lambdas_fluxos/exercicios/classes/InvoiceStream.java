package com.estudosjava.javacomoprogramar.javacore.capitulo17_lambdas_fluxos.exercicios.classes;

import com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.classes.Invoice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InvoiceStream {
    public static void main(String[] args) {
        Invoice[] invoices = {
                new Invoice("83", 7, "Electric sander", 57.98),
                new Invoice("24", 18, "Electric sander", 99.99),
                new Invoice("7", 11, "Sledge hammer", 21.50),
                new Invoice("77", 76, "Hammer", 11.99),
                new Invoice("39", 3, "Lawn mower", 79.50),
                new Invoice("68", 106, "Screwdriver", 6.99),
                new Invoice("56", 21, "Jig saw", 11.00),
                new Invoice("3", 34, "Wrench", 7.50),
        };

        List<Invoice> invoicesList = Arrays.asList(invoices);

        Map<String, List<Invoice>> agrupadosPorDescricao =  invoicesList.stream().collect(Collectors.groupingBy(Invoice::getPartDescription));

        /*System.out.printf("Agrupados por descricao%n");
        agrupadosPorDescricao.forEach((description, invoicesWithDescription) -> {
            System.out.printf("Descricao: %s%n", description);
            invoicesWithDescription.forEach(invoice -> System.out.println(invoice));
            System.out.println();
        });*/


        /*System.out.printf("Agrupados por preco%n");
        Map<Double, List<Invoice>> agrupadosPorPreco = invoicesList.stream().collect(Collectors.groupingBy(Invoice::getPricePerItem));
        agrupadosPorPreco.forEach((preco, invoicesWithSomePrice) -> {
            System.out.printf("Preco: %s%n", preco);
            invoicesWithSomePrice.forEach(invoice -> System.out.println(invoice));
            System.out.println();
        });*/

        Predicate<Invoice> predicate = invoice -> invoice.getPricePerItem() >= 50 && invoice.getPricePerItem() <= 500;
        System.out.printf("Entre US$ 200 a US$ 500%n");
        invoicesList.stream().filter(predicate).forEach(System.out::println);
        /*invoicesList.stream().map(invoice -> invoice.getPartDescription() + " " + invoice.getQuantity()).forEach(System.out::println);

        System.out.println("Classificados por quantidade: ");
        Map<Integer, List<Invoice>> agrupadosPorQuantidade = invoicesList.stream().collect(Collectors.groupingBy(Invoice::getQuantity));
        agrupadosPorQuantidade.forEach((quantity, invoicesWithQuantity) -> {
            System.out.printf("Quntidade: %s%n", quantity);
            invoicesWithQuantity.forEach(invoice -> System.out.println(invoice));
            System.out.println();
        });*/

    }
}
