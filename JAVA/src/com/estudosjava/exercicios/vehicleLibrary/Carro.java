package com.estudosjava.exercicios.vehicleLibrary;

public class Carro extends Veiculo{
    private int numOfPortas;
    public Carro(String marca, String modelo, String placa, int ano, int numOfPortas) {
            super(marca, modelo, ano, placa);
        if(numOfPortas <= 0)
            throw new IllegalArgumentException("Numero de Portas invalida");
        this.numOfPortas = numOfPortas;
    }

    public int getNumOfPortas() {
        return numOfPortas;
    }

    public void setNumOfPortas(int numOfPortas) {
        if(numOfPortas <= 0)
            throw new IllegalArgumentException("Numero de Portas invalida");
        this.numOfPortas = numOfPortas;
    }

    @Override
    public double calcularCustoDeManutencao() {
        return 500 + (50 * getNumOfPortas());
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %s%n%s%n%s: %02d",
                "Tipo",
                "Carro",
                super.toString(),
                "Numero de portas",
                getNumOfPortas()
        );
    }
}
