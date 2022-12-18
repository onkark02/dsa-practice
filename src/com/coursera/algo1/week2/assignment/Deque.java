package com.coursera.algo1.week2.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private Node first, last;
    private int size;

    // construct an empty deque
    public Deque() {
        first = last = null;
        size = 0;
    }


    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        checkInput(item);
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            first = last = node;
            node.next = null;
            node.prev = null;
        } else {
            first.prev = node;
            node.next = first;
            node.prev = null;
            first = node;
        }
        size++;
    }


    // add the item to the back
    public void addLast(Item item) {
        checkInput(item);
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            first = last = node;
            node.next = null;
            node.prev = null;
        } else {
            node.prev = last;
            last.next = node;
            node.next = null;
            last = node;
        }
        size++;
    }

    private void checkInput(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Please provide non-null input");
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("No element present");
        }
        Node node = first;
        if (size == 1) {
            first = last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        size--;
        return node.item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("No element present");
        }
        Node node = last;
        if (size == 1) {
            first = last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        size--;
        return node.item;
    }


    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            if (current == null)
                return false;
            return true;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next element present");
            }
            Node node = current;

            current = current.next;

            return node.item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove operation not allowed");
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        System.out.println(deque.size());
        deque.addFirst(5);
        deque.addFirst(6);
        deque.addLast(4);
        deque.addLast(3);
        for (Integer i : deque
        ) {
            System.out.println(i);
        }
/*        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
        System.out.println(deque.isEmpty());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.size());
        System.out.println(deque.removeLast());*/
    }

}
