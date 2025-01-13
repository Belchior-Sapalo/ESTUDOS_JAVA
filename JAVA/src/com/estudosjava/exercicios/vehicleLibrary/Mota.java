package com.estudosjava.exercicios.vehicleLibrary;

public class Mota extends Veiculo{
    private double cilindrada;
    public Mota(String marca, String modelo, String placa, int ano, double cilindrada){
        super(marca, modelo, ano, placa);
        if(cilindrada < 0)
            throw new IllegalArgumentException("Cilindrada invalida");
        this.cilindrada = cilindrada;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularCustoDeManutencao() {
        return 300 + (0.1 * getCilindrada());
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %s%n%s%n%s: %s",
                "Tipo",
                "Mota",
                super.toString(),
                "Cilindrada",
                getCilindrada()
        );
    }
}
