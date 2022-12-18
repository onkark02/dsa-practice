package com.coursera.algo1.week2;


import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class Node{
        Item data;
        Node next;
    }
    private Node first = null;

    public void push(Item data){
        Node oldFirst = first;
        first = new Node();
        first.data = data;
        first.next = oldFirst;
    }

    public Item pop(){
        Item data = first.data;
        first = first.next;
        return data;
    }

    public boolean isEmpty(){
        return null == first;
    }
}
