package com.estudosjava.exercicios.vehicleLibrary;

public abstract class Veiculo implements Imanutencao{
    private String marca;
    private String modelo;
    private String placa;
    private int ano;

    public Veiculo(String marca, String modelo, int ano, String placa) {
        if(marca == null || modelo == null || placa == null || ano <= 0)
            throw new IllegalArgumentException("Argumentos invalidos, verifique-os");
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if(marca == null)
            throw new IllegalArgumentException("Marca invalida");
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if(modelo == null)
            throw new IllegalArgumentException("Modelo invalido");
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if(ano <= 0)
            throw new IllegalArgumentException("Ano invalido");
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if(placa == null)
            throw new IllegalArgumentException("Placa invalido");
        this.placa = placa;
    }

    public String toString(){
        return String.format(
                "%s: %s%n%s: %s%n%s: %s%n%s: %d",
                "Marca",
                getMarca(),
                "Modelo",
                getModelo(),
                "Placa",
                getPlaca(),
                "Ano",
                getAno()
        );
    }
}
