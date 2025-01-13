package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exemplos;

public class TreeNode<T extends Comparable<T>>{
    TreeNode<T> leftNode;
    T data;
    TreeNode<T> rightNode;

    public TreeNode(T data) {
        this.data = data;
        this.leftNode = this.rightNode = null;
    }

    public void insert(T newData) {

        if(newData.compareTo(data) < 0){
            if(leftNode == null)
                leftNode = new TreeNode<>(data);
            else
                leftNode.insert(data);
        } else if (newData.compareTo(data) > 0) {
            if(rightNode == null)
                rightNode = new TreeNode<>(data);
            else
                rightNode.insert(data);
        }
    }
}
