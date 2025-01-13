package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exercicios.sotedList;

public class SortedList<T extends Comparable<T>>{
    private ListNode<T> firstNode;
    private ListNode<T> lastNode;
    private int size;

    public void insert(T element) {
        if (firstNode == null)
            firstNode = lastNode = new ListNode(element);
        else{
            firstNode = new ListNode(null, element, firstNode);
            size++;
            sort();
        }
    }

    private void sort(){
        for (int i = 0; i < size; i++){
            boolean wasSwitcher = false;
            for (int j = 1; j <= size - i; j++){
                T actualValue = get(j).getData();
                T nextValue = get(j+1).getData();
                if(actualValue.compareTo(nextValue) > 0){
                    get(j + 1).setData(actualValue);
                    get(j).setData(nextValue);
                    wasSwitcher = true;
                }
            }
            if(!wasSwitcher) break;
        }
    }

    public ListNode<T> get(int index) {
        ListNode<T> current = firstNode;
        for(int i = 1; i < index; i++){
            current = current.getNext();
        }
        return current;
    }

    public void print(){
        ListNode<T> current = firstNode;
        while (current != null){
            System.out.printf("%s ", current.getData());
            current = current.getNext();
        }
    }
}
