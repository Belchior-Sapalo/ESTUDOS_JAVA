package com.estudosjava.maratonajava.javacore.Exceptions.exceptionscustomizadas.classes;

public class Funcionario extends Pessoa{
    @Override
    //Subclasses nao sao obrigadas a lancar a exception de um metodo sobrescrito
    //Subclasses podem lancar apes uma das exceptions de um metodo sobrescrito
    //Subclasses nao podem lancar exceptions que nao foram declaradas no metodo da superclass
    //Subclasses podem lancar exceptions de subclasses das classes de exceptions na superclasse
    public void salvar(){

    }
}
