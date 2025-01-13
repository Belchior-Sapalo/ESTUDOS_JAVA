package com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Binterfaces.classes;

public abstract class Employee implements Payable{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private Date birthDate;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String toString() {
        return String.format(
                "%s %s%nsocial security number: %s",
                getFirstName(),
                getLastName(),
                getSocialSecurityNumber()
        );
    }
}
