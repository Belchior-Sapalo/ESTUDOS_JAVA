package com.estudosjava.exercicios.banco;

public abstract class Conta implements Ioperacoes{
    private int numeroConta;
    private Titular titular;
    private double saldo;

    public Conta(int numeroConta, String titlularFistName, String titularLastName, String titularBI, double saldo) {
        if(numeroConta <= 0)
            throw new IllegalArgumentException("Numero de conta invalido");
        this.numeroConta = numeroConta;
        this.titular = new Titular(titlularFistName, titularLastName, titularBI);
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        if(numeroConta <= 0)
            throw new IllegalArgumentException("Numero de conta invalido");
        this.numeroConta = numeroConta;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void depositar(double valor) {
        if(valor <= 0)
            throw new IllegalArgumentException("Valor invalido");
        this.setSaldo(this.getSaldo() + valor);
    }

    public String toString(){
        return String.format(
                "%s%n%s: %s%n%s: %s%n%s: %.2f",
                "***DETALHES DA CONTA***",
                "Numedo da conta",
                getNumeroConta(),
                "Titular",
                getTitular(),
                "Saldo",
                getSaldo()
        );
    }
}
