package com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Binterfaces.classes;

public class SalariedEmployee extends Employee{
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNUmber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNUmber);
        if(weeklySalary < 0)
            throw new IllegalArgumentException("Weekly salary cannot be negative");
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        if(weeklySalary < 0)
            throw new IllegalArgumentException("Weekly salary cannot be negative");
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getPayamentAmount() {
        return getWeeklySalary();
    }

    public String toString(){
        return String.format(
                "salaried employee: %s%n%s: $%,.2f",
                super.toString(),
                "weekly salary", getWeeklySalary()
        );
    }
}
