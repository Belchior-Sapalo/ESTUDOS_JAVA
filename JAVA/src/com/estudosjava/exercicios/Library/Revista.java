package com.estudosjava.exercicios.Library;

public class Revista extends ItemLibrary{
    private int edicao;

    public Revista(String id, String titulo, ItemStatus status, int edicao) {
        super(id, titulo, status);
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    @Override
    public String toString(){
        return String.format(
                "%s%n%s: %s%n",
                super.toString(),
                "Edicao",
                getEdicao()
        );
    }
}
