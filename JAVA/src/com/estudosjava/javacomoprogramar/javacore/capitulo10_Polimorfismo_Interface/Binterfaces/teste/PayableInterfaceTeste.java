package com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Binterfaces.teste;

import com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Binterfaces.classes.Invoice;
import com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Binterfaces.classes.Payable;
import com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Binterfaces.classes.SalariedEmployee;

import java.util.Date;

public class PayableInterfaceTeste {
    Date dt = new Date();
    public static void main(String[] args) {
        Payable[] payableObjects = new Payable[4];
        payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
        payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
        payableObjects[2] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
        payableObjects[3] = new SalariedEmployee("Lisa", "Barnes", "888-88-8888", 1200.00);

        for(Payable currentPayable : payableObjects){
            System.out.printf(
                    "%n%s %n%s: $%,.2f%n",
                    currentPayable.toString(),
                    "payment due", currentPayable.getPayamentAmount()
            );
        }

    }
}
