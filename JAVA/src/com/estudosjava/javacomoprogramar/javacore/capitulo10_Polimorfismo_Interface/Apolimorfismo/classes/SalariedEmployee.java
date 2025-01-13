package com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.classes;

public class SalariedEmployee extends Employee{
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public String toString(){
        return String.format(
                "%s%n%s: %.2f%n%s: %.2f",
                super.toString(),
                "Weekly salary",
                getWeeklySalary(),
                "Earnings",
                earnings()
        );
    }

    public double earnings(){
        return getWeeklySalary();
    }

    @Override
    //Quando a superclasse implementa uma interface, ela deve implementar todos os metodos dessa interface ou ser declarada
    //como uma classe asbtracta e desse modo, as subclasses tera que implementar
    //os metos da interface cumprindo assim o contrato da superclasse
    public double getPaymentAmount() {
        return getWeeklySalary();
    }
}
