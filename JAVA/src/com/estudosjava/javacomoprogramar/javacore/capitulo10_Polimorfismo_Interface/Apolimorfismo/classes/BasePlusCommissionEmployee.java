package com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.classes;

public class BasePlusCommissionEmployee extends CommissionEmployee{
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double commissionRate, double grossSales, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, commissionRate, grossSales);
        if(baseSalary < 0)
            throw new IllegalArgumentException("Base Salary cannot be negative");
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if(baseSalary < 0)
            throw new IllegalArgumentException("Base Salary cannot be negative");
        this.baseSalary = baseSalary;
    }

    public String toString() {
        return String.format("%s%n%s: %.2f",
                super.toString(),
                "Base salary",
                getBaseSalary()
        );
    }

    @Override
    public double earnings(){
        return super.earnings() + getBaseSalary();
    }
}
