package com.coursera.algo1.week2;

public class LinkedStackOfStrings {
    private class Node{
        String data;
        Node next;
    }
    private Node first = null;

    public void push(String data){
        Node oldFirst = first;
        first = new Node();
        first.data = data;
        first.next = oldFirst;
    }

    public String pop(){
        String data = first.data;
        first = first.next;
        return data;
    }

    public boolean isEmpty(){
        return null == first;
    }
}
