package com.coursera.algo1.week2.assignment;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item>{
    // construct an empty randomized queue
    private Item[] queue;
    private int elementCount; // elementCount value is number of values in queue
    public RandomizedQueue(){
        queue = (Item[]) new  Object[2];
        elementCount=0;
    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return elementCount==0;
    }

    // return the number of items on the randomized queue
    public int size(){
        return elementCount;
    }

    // add the item
    public void enqueue(Item item){
        if(item==null){
            throw new IllegalArgumentException("Input value should be non-null");
        }
        if(queue.length==elementCount){
            resize(2*queue.length);
        }
        queue[elementCount++]=item;
    }

    private void resize(int n){
        Item[] temp= (Item[]) new Object[n];
        for(int i=0; i< elementCount; i++){
            temp[i]=queue[i];
        }
        queue = temp;
    }
    private void swap(int i, int j){
        if(i==j)
            return;
        Item temp = queue[i];
        queue[i] = queue[j];
        queue[j]=temp;
    }
    private int getRandomIndex(){
/*           if(elementCount == 1){
            return 0;
        }*/
        return StdRandom.uniform(0, elementCount) ;
    }

    // remove and return a random item
    public Item dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        if(elementCount == queue.length/4){
            resize(queue.length/2);
        }
        swap(getRandomIndex(), elementCount-1);
        Item item = queue[elementCount-1];
        queue[--elementCount] = null; //To avoid loitering i.e. clearing references
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        int randomIndex = getRandomIndex();
        return queue[randomIndex];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new RQueueIterator();
    }

    private class RQueueIterator implements Iterator<Item> {
        private  Item[] iteratorArray;
        private int iteratorElementCount;
        public RQueueIterator(){
            iteratorArray = (Item[]) new Object[elementCount];
            for(int i=0; i<elementCount;i++)
                iteratorArray[i]=queue[i];
            iteratorElementCount = elementCount;
        }

        @Override
        public boolean hasNext() {
            return iteratorElementCount!=0;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException("No element is present");
            }
            swapIterator(getRandomIndexIterator(), iteratorElementCount-1);
            Item item = iteratorArray[iteratorElementCount-1];
            iteratorArray[--iteratorElementCount] = null; //To avoid loitering i.e. clearing references
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation not allowed");
        }
        private void swapIterator(int i, int j){
            if(i==j)
                return;
            Item temp = iteratorArray[i];
            iteratorArray[i] = iteratorArray[j];
            iteratorArray[j]=temp;
        }
        private int getRandomIndexIterator(){
/*           if(elementCount == 1){
            return 0;
        }*/
            return StdRandom.uniform(0, iteratorElementCount) ;
        }
    }


    // unit testing (required)
    public static void main(String[] args){
        RandomizedQueue<Integer> rQueue = new RandomizedQueue<>();
        System.out.println(rQueue.isEmpty());
        rQueue.enqueue(1);
        rQueue.enqueue(2);
        rQueue.enqueue(3);
        rQueue.enqueue(4);
        System.out.println(rQueue.isEmpty());
        System.out.println(rQueue.sample());
        System.out.println(rQueue.size());
        System.out.println(rQueue.dequeue());
        System.out.println(rQueue.dequeue());
        System.out.println(rQueue.dequeue());
        System.out.println(rQueue.dequeue());
//        System.out.println(rQueue.dequeue());
        System.out.println("__________________________");
        System.out.println(rQueue.isEmpty());
        rQueue.enqueue(1);
        rQueue.enqueue(2);
        rQueue.enqueue(3);
        rQueue.enqueue(4);
        System.out.println("__________________________");

        for (Integer i:
             rQueue) {
            System.out.println(i);
        }
        System.out.println("__________________________");
        System.out.println(rQueue.isEmpty());
        System.out.println(rQueue.sample());
        System.out.println(rQueue.size());
        System.out.println(rQueue.dequeue());
        System.out.println(rQueue.dequeue());
        System.out.println(rQueue.dequeue());
        System.out.println(rQueue.dequeue());
    }

}
