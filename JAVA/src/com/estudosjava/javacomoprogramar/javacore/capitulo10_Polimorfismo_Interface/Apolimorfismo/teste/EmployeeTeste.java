package com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.teste;

import com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.classes.*;

public class EmployeeTeste {
    public static void main(String[] args) {
        SalariedEmployee salariedEmployee = new SalariedEmployee("Belchior", "Sapalo", "123450", 10000);

        HourlyEmployee hourlyEmployee = new HourlyEmployee("Agostinho", "Sapalo", "12345", 10, 20);

        CommissionEmployee commissionEmployee = new CommissionEmployee("Luisa", "Mendes", "12345", 0.5, 1000);

        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Paulo", "Sapalo", "12345", 0.5, 1000, 5000);

        Employee[] employees = {salariedEmployee, hourlyEmployee, commissionEmployee, basePlusCommissionEmployee};

        for (Employee employee : employees) {
            System.out.println(employee);
            if(employee instanceof BasePlusCommissionEmployee){
                BasePlusCommissionEmployee employee1 = (BasePlusCommissionEmployee) employee;
                employee1.setBaseSalary(1.1 * employee1.getBaseSalary());
                System.out.printf("%s: %.2f", "Base salary with 10%", employee1.getBaseSalary());
            }
            System.out.println("#########################");
        }
    }
}
