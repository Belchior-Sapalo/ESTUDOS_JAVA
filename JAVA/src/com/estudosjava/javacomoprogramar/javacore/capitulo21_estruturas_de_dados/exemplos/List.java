package com.estudosjava.javacomoprogramar.javacore.capitulo21_estruturas_de_dados.exemplos;

public class List<T>{
    private ListNode<T> firstNode;
    private ListNode<T> lastNode;
    private String name;
    private int size;

    public List(){
        this("List");
    }

    public List(String name){
        this.name = name;
        this.firstNode = null;
    }

    public void insertAtFront(T data){
        if(isEmpty())
            firstNode = lastNode = new ListNode<T>(data);
        else
            firstNode = new ListNode<T>(data, firstNode);
        size++;
    }

    public void insertAtBack(T data){
        if(isEmpty())
            firstNode = lastNode = new ListNode<T>(data);
        else
            lastNode = lastNode.next = new ListNode<T>(data);
        size++;
    }

    public T removeFromFront() throws EmptyListException{
        if(isEmpty())
            throw new EmptyListException();

        T revovedItem = firstNode.data;
        if(firstNode == lastNode)
            firstNode = lastNode =null;
        else
            firstNode = firstNode.next;
        size--;
        return revovedItem;
    }

    public T removeFromBack() throws EmptyListException{
        if(isEmpty())
            throw new EmptyListException();

        T revovedItem = lastNode.data;
        if(firstNode == lastNode)
            firstNode = lastNode =null;
        else{
            ListNode<T> current = firstNode;
            while (current.next != lastNode)
                current = current.next;
            lastNode = current;
            current.next = null;
        }
        size--;
        return revovedItem;
    }

    public void print(){
        if(isEmpty()){
            System.out.printf("Empty %s%n", name);
            return;
        }
        System.out.printf("The %s is: ", name);

        ListNode<T> current = firstNode;
        while(current != null){
            System.out.printf("%s ", current.data);
            current = current.next;
        }
        System.out.println();
    }

    public String merge(){
        String result = "";
        ListNode<T> current = firstNode;
       for(int i = 1; i <= size; i++){
           result += current.data + "";
           current = current.next;
       }
        return result;
    }

    public boolean isEmpty(){
        return firstNode == null;
    }
}
