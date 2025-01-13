package com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.teste;

import com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.classes.Invoice;
import com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.classes.Payable;
import com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Apolimorfismo.classes.SalariedEmployee;

public class PayableInterfaceTeste {
    public static void main(String[] args) {
        Payable[] payableObjects = new Payable[4];
        payableObjects[0] = new Invoice("01234", 2,"seat", 375.0);
        payableObjects[1] = new Invoice("56789", 4,"tire", 79.95);
        payableObjects[2] = new SalariedEmployee("Belchior", "Sapalo","12345", 800);
        payableObjects[3] = new SalariedEmployee("Agostinho", "Sapalo","6789", 1200.00);

        for(Payable currentPayableObject : payableObjects){
            System.out.printf("%n%s %n%s: $%,.2f%n",
                    currentPayableObject,
                    "payament amount", currentPayableObject.getPaymentAmount()
            );
        }
    }
}
