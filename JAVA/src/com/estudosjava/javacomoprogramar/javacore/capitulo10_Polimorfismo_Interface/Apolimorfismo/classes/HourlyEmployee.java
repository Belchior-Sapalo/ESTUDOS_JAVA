package com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.classes;

public class HourlyEmployee extends Employee{
    private double hoursWorked;
    private double hourWage;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hoursWorked, double hourWage) {
        super(firstName, lastName, socialSecurityNumber);
        if(hoursWorked < 0 || hoursWorked > 186.0)
            throw new IllegalArgumentException("Hour must be between 0 and 186.0");
        if(hourWage < 0)
            throw new IllegalArgumentException("Wage must be bigest than 0");
        this.hoursWorked = hoursWorked;
        this.hourWage = hourWage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if(hoursWorked < 0 || hoursWorked > 186.0)
            throw new IllegalArgumentException("Hour must be between 0 and 186.0");
        this.hoursWorked = hoursWorked;
    }

    public double getHourWage() {
        return hourWage;
    }

    public void setHourWage(double hourWage) {
        if(hourWage < 0)
            throw new IllegalArgumentException("Wage must be bigest than 0");
        this.hourWage = hourWage;
    }

    public String toString(){
        return String.format(
                "%s%n%s: %.2f%n%s: %.2f%n%s: %.2f",
                super.toString(),
                "Hours worked",
                getHoursWorked(),
                "Hours wage",
                getHourWage(),
                "Earning",
                earnings()
        );
    }

    @Override
    public double earnings() {
        return getHoursWorked() <= 40 ?
                getHoursWorked() * getHourWage():
                40 * getHourWage() + (getHoursWorked() - 40) * getHourWage() * 1.5;
    }
    public double getPaymentAmount() {
        return 0;
    }
}
