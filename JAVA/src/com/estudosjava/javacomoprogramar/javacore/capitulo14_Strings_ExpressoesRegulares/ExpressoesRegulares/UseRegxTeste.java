package com.estudosjava.javacomoprogramar.javacore.capitulo14_Strings_ExpressoesRegulares.ExpressoesRegulares;

import java.util.Scanner;

public class UseRegxTeste {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Primeiro nome");
        String firstName = s.nextLine();
        System.out.println("Segundo nome");
        System.out.println("Endereco");
        String address = s.nextLine();
        String lastName = s.nextLine();
        System.out.println("Cidade");
        String city = s.nextLine();
        System.out.println("Estado");
        String state = s.nextLine();
        System.out.println("Zip code");
        String zip = s.nextLine();
        System.out.println("Telefone");
        String phone = s.nextLine();

        System.out.println("%nValidate Result:");
        if(!ValidateInput.validateFirstName(firstName))
            System.out.println("First name is not valid");
        else if(!ValidateInput.validateLastName(lastName))
            System.out.println("Last name is not valid");
        else if(!ValidateInput.validateAddress(address))
            System.out.println("Address is not valid");
        else if(!ValidateInput.validateCity(city))
            System.out.println("City is not valid");
        else if(!ValidateInput.validateState(state))
            System.out.println("State is not valid");
        else if(!ValidateInput.validateZipCode(zip))
            System.out.println("Zip code is not valid");
        else if(!ValidateInput.validatePhone(phone))
            System.out.println("Phone is not valid");
        else
            System.out.println("Entradas validadas");

    }
}
