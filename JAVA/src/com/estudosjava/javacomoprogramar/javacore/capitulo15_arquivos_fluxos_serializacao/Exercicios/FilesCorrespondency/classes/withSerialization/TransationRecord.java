package com.estudosjava.javacomoprogramar.javacore.capitulo15_arquivos_fluxos_serializacao.Exercicios.FilesCorrespondency.classes.withSerialization;

import java.io.Serializable;

public class TransationRecord implements Serializable {
    private int accountNumeber;
    private double transactionAmount;

    public TransationRecord(int accountNumeber, double transactionAmount) {
        if(accountNumeber <= 0)
            throw new IllegalArgumentException("account number deve ser maior que zero");
        this.accountNumeber = accountNumeber;
        this.transactionAmount = transactionAmount;
    }

    public int getAccountNumeber() {
        return accountNumeber;
    }

    public void setAccountNumeber(int accountNumeber) {
        if(accountNumeber <= 0)
            throw new IllegalArgumentException("account number deve ser maior que zero");
        this.accountNumeber = accountNumeber;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
