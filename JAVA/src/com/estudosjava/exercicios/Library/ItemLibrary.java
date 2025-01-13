package com.estudosjava.exercicios.Library;

import com.estudosjava.maratonajava.javacore.Exceptions.exceptionscustomizadas.classes.ItemNaoEmprestadoException;

public class ItemLibrary implements Emprestavel {
    private String id;
    private String titulo;
    private ItemStatus status;

    public ItemLibrary(String id, String titulo, ItemStatus status) {
        this.id = id;
        this.titulo = titulo;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    @Override
    public void emprestar() throws ItemJaEmprestadoException {
        if(this.getStatus().equals(ItemStatus.INDISPONIVEL))
            throw new ItemJaEmprestadoException("Item ja emprestado");
        this.setStatus(ItemStatus.INDISPONIVEL);
    }

    @Override
    public void devolver() throws ItemNaoEmprestadoException {
        if(this.getStatus().equals(ItemStatus.DISPONIVEL))
            throw new ItemNaoEmprestadoException("Item nao emprestado");
        this.setStatus(ItemStatus.DISPONIVEL);
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %s%n%s: %s%n%s: %s",
                "Titulo",
                getTitulo(),
                "ID",
                getId(),
                "Status",
                getStatus()
        );
    }
}
