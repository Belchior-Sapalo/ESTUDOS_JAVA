package com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.classes;

public abstract class Employee implements Payable{
   private String firstName;
   private String lastName;
   private String socialSecurityNumber;

   public Employee(String firstName, String lastName, String socialSecurityNumber) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.socialSecurityNumber = socialSecurityNumber;
   }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String toString() {
       return String.format(
               "%s: %s %s%n%s: %s",
               "Name", firstName, lastName,
               "Social security number", socialSecurityNumber
       );
    }

    public abstract double earnings();
}
