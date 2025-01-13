package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exemplos;

import java.security.SecureRandom;

public class TreeTest {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        SecureRandom random = new SecureRandom();

        System.out.println("Inserting the following values: ");

        for (int i = 0; i <= 10; i++) {
            int value = random.nextInt(100);
            System.out.printf("%d ", value);
            tree.insertNode(value);
        }

        System.out.printf("%n%nPreorder traversal%n");
        tree.preOrderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree.inOrderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree.postOrderTraversal();
    }
}
