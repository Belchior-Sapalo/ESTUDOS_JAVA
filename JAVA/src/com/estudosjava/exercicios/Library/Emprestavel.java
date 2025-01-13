package com.estudosjava.exercicios.Library;

import com.estudosjava.maratonajava.javacore.Exceptions.exceptionscustomizadas.classes.ItemNaoEmprestadoException;

public interface Emprestavel {
    void emprestar() throws ItemJaEmprestadoException;
    void devolver() throws ItemNaoEmprestadoException;
}
