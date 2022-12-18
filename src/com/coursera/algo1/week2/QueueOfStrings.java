package com.coursera.algo1.week2;

import java.util.NoSuchElementException;

public class QueueOfStrings {
    private class Node{
        String item;
        Node next;
    }
    Node head, tail;

    public QueueOfStrings(){
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }
    public void enqueue(String s){
        Node oldLast = tail;
        tail = new Node();
        tail.item=s;
        tail.next=null;
        if(isEmpty()) {
            head = tail;
        }else {
            oldLast.next = tail;
        }
    }
    public String deque(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node node = head;
        head = head.next;
        if(isEmpty()){
            tail = null;
        }
        return node.item;
    }

    public static void main(String[] args) {
        QueueOfStrings queue = new QueueOfStrings();
        queue.enqueue("first");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        System.out.println(queue.deque());
        System.out.println(queue.isEmpty());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.isEmpty());
        System.out.println(queue.deque());
    }
}
