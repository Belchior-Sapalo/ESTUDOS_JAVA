package com.estudosjava.javacomoprogramar.javacore.capitulo24_JDBC.catalogo_app;

import com.estudosjava.maratonajava.javacore.Exceptions.exceptionscustomizadas.classes.Pessoa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AddressBookDisplay {
    public static void main(String[] args) {
        PersonQueries personQueries = new PersonQueries();
        List<Person> results = new ArrayList<>();
        results = personQueries.getAllPeople();

        results.stream().sorted(Comparator.comparing(Person::getFirstName)).forEach(System.out::println);
    }
}
