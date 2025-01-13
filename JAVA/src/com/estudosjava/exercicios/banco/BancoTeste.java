package com.estudosjava.exercicios.banco;

import java.util.ArrayList;

public class BancoTeste {
    public static void main(String[] args) {
        ContaPoupanca contaPoupanca = new ContaPoupanca(2055854, "Belchior", "Sapalo", "025HO", 2000, 20);
        ContaCorrente contaCorrente = new ContaCorrente(125852, "Agostinho", "Sapalo", "02585BO", 2000, 500);

        contaPoupanca.depositar(1000);
        System.out.println(contaPoupanca.getSaldo());
        ArrayList<String> teste = new ArrayList<>();

    }
}
