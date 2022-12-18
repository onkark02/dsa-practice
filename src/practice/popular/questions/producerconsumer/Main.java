package practice.popular.questions.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue,10);
        Consumer consumer = new Consumer(queue);
        Thread producerThread = new Thread(producer);
        producerThread.setName("producer");
        Thread consumerThread = new Thread(consumer);
        consumerThread.setName("consumer");
        consumerThread.start();
        producerThread.start();
    }
}
