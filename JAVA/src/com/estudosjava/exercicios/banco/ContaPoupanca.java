package com.estudosjava.exercicios.banco;

public class ContaPoupanca extends Conta{
    private double taxaDeRendimento;
    public ContaPoupanca(int numeroConta, String titlularFistName, String titularLastName, String titularBI, double saldo, double taxaDeRendimento) {
        super(numeroConta, titlularFistName, titularLastName, titularBI, saldo);
        if(taxaDeRendimento < 0)
            throw new IllegalArgumentException("Taxa de rendimento nao pode ser negativa");
        this.taxaDeRendimento = taxaDeRendimento;
    }

    public double getTaxaDeRendimento() {
        return taxaDeRendimento;
    }

    public void setTaxaDeRendimento(double taxaDeRendimento) {
        this.taxaDeRendimento = taxaDeRendimento;
    }

    @Override
    public void sacar(double valor) {
        if(valor <= 0)
            throw new IllegalArgumentException("Valor nao pode ser negativa");
        if(valor > getSaldo())
            throw new IllegalArgumentException("Saldo insuficiente");
        setSaldo(getSaldo() - valor);
    }

    @Override
    public double calcucarSaldo() {
        return getSaldo() + (getTaxaDeRendimento() * getSaldo());
    }

    @Override
    public String toString(){
        return String.format(
                "%s%n%s: %.2f",
                super.toString(),
                "Taxa de rendimento",
                getTaxaDeRendimento()
        );
    }
}
