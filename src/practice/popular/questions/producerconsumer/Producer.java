package practice.popular.questions.producerconsumer;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable{
    public Producer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize=maxSize;
    }

    private final Queue<Integer> queue;
    private int maxSize;
    @Override
    public void run() {
        produce();
    }

    private void produce(){
        while (true) {
            synchronized (queue) {
                while (queue.size() >= maxSize) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int val = new Random().nextInt(100);
                System.out.println(Thread.currentThread().getName() + ": Produced value: " + val);
                queue.offer(val);
                System.out.println(Thread.currentThread().getName() + ": Queue size: " + queue.size());
                queue.notifyAll();
            }
/*            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
