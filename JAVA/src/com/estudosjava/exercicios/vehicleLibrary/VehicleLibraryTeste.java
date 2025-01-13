package com.estudosjava.exercicios.vehicleLibrary;

public class VehicleLibraryTeste {
    public static void main(String[] args) {
        Carro car = new Carro("Hilux", "Toyota", "HO0224",2000, 4);
        Mota mota = new Mota("Bajaja", "b220", "BJ0225",1999, 180);

        Veiculo[] veiculos = {car, mota};
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
            System.out.printf("%s: %s%n", "Custo de manutencao", veiculo.calcularCustoDeManutencao());
            System.out.println("");
        }
    }
}
