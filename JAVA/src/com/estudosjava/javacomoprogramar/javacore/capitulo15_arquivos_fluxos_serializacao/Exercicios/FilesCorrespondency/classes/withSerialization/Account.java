package com.estudosjava.javacomoprogramar.javacore.capitulo15_arquivos_fluxos_serializacao.Exercicios.FilesCorrespondency.classes.withSerialization;

import java.io.Serializable;

public class Account implements Serializable {
    private int account;
    private String FirstName;
    private String LastName;
    private double balance;

    public Account(){
        this(0, "", "", 0.0);
    }

    public Account(int account, String firstName, String lastName, double balance){
        this.account = account;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.balance = balance;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void combine(TransationRecord transationRecord){
        this.balance += transationRecord.getTransactionAmount();
    }
}
