package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exemplos;

public class Tree<T extends Comparable<T>>{
    private TreeNode<T> root;

    public Tree() {
        root = null;
    }

    public void insertNode(T newValue) {
        if(root == null)
            root = new TreeNode<>(newValue);
        else
            root.insert(newValue);
    }

    public void preOrderTraversal() {
        preorderHelper(root);
    }

    private void preorderHelper(TreeNode<T> node) {
        if (node == null)
            return;
        System.out.printf("%s ", node.data); // gera saída de dados do nó
        preorderHelper(node.leftNode); // percorre subárvore esquerda
        preorderHelper(node.rightNode); // percorre subárvore direita
    }

    public void inOrderTraversal() {
        inOrderHelper(root);
    }

    private void inOrderHelper(TreeNode<T> node) {
        if (node == null)
            return;
        inOrderHelper(node.leftNode); // percorre subárvore esquerda
        System.out.printf("%s ", node.data); // gera saída de dados do nó
        inOrderHelper(node.rightNode); // percorre subárvore direita
    }

    public void postOrderTraversal() {
        posOrderHelper(root);
    }

    private void posOrderHelper(TreeNode<T> node) {
        if (node == null)
            return;
        posOrderHelper(node.leftNode); // percorre subárvore esquerda
        posOrderHelper(node.rightNode); // percorre subárvore direita
        System.out.printf("%s ", node.data); // gera saída de dados do nó
    }
}
