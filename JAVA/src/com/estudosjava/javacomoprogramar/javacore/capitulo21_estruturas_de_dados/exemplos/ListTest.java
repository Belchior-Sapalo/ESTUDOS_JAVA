package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exemplos;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> lista = new List<>();

        lista.insertAtFront(-1);
        lista.print();
        lista.insertAtFront(0);
        lista.print();
        lista.insertAtBack(1);
        lista.print();
        lista.insertAtBack(5);
        lista.print();

        try{
            int removed = lista.removeFromFront();
            System.out.printf("%n%d removed%n", removed);
            lista.print();

            removed = lista.removeFromFront();
            System.out.printf("%n%d removed%n", removed);
            lista.print();

            removed = lista.removeFromBack();
            System.out.printf("%n%d removed%n", removed);
            lista.print();

            removed = lista.removeFromBack();
            System.out.printf("%n%d removed%n", removed);
            lista.print();
        }catch (EmptyListException e){
            System.out.println("Lista vazia");
        }
    }
}
