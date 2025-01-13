package com.estudosjava.exercicios.banco;

public class ContaCorrente extends Conta{
    private double limiteDeChequeEspecial;

    public ContaCorrente(int numeroConta, String titlularFistName, String titularLastName, String titularBI, double saldo, double limiteDeChequeEspecial){
        super(numeroConta, titlularFistName, titularLastName, titularBI, saldo);
        this.limiteDeChequeEspecial = limiteDeChequeEspecial;
    }

    public double getLimiteDeChequeEspecial() {
        return limiteDeChequeEspecial;
    }

    public void setLimiteDeChequeEspecial(double limiteDeChequeEspecial) {
        this.limiteDeChequeEspecial = limiteDeChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if(valor <= 0)
            throw new IllegalArgumentException("Valor invalido");
        if(valor > getSaldo() + getLimiteDeChequeEspecial())
            throw new IllegalArgumentException("Saldo insuficiente");
        setSaldo(getSaldo() - valor);
    }

    @Override
    public double calcucarSaldo() {
        return getSaldo() + getLimiteDeChequeEspecial();
    }

    @Override
    public String toString(){
        return String.format(
                "%s%n%s: %.2f",
                super.toString(),
                "Limite de cheque",
                getLimiteDeChequeEspecial()
        );
    }
}
