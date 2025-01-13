package com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.classes;

public class CommissionEmployee extends Employee{
    private double commissionRate;
    private double grossSales;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double commissionRate, double grossSales) {
        super(firstName, lastName, socialSecurityNumber);
        if(commissionRate < 0 || commissionRate >= 1)
            throw new IllegalArgumentException("Commission rate must be between 0 and 1");
        if(grossSales < 0)
            throw new IllegalArgumentException("Gross salary cannot be negative");
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        if(commissionRate < 0 || commissionRate >= 1)
            throw new IllegalArgumentException("Commission rate must be between 0 and 1");
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        if(grossSales < 0)
            throw new IllegalArgumentException("Gross salary cannot be negative");
        this.grossSales = grossSales;
    }

    public String toString() {
        return String.format("%s%n%s: %s%n%s: %s%n%s: %.2f",
                super.toString(),
                "Commission rate",
                getCommissionRate(),
                "Gross sales",
                getGrossSales(),
                "Earning",
                earnings()
                );
    }

    @Override
    public double earnings() {
        return getCommissionRate() * getGrossSales();
    }

    public double getPaymentAmount() {
        return 0;
    }
}
