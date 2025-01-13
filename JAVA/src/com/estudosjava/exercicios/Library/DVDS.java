package com.estudosjava.exercicios.Library;

public class DVDS extends ItemLibrary{
    private int duracao;

    public DVDS(String id, String titulo, ItemStatus status, int duracao) {
        super(id, titulo, status);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString(){
        return String.format(
                "%s%n%s: %s%n",
                super.toString(),
                "Duracao",
                getDuracao()
        );
    }
}
