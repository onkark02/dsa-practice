package practice.popular.questions.producerconsumer;

import java.util.Queue;

public class Consumer implements Runnable{
    private final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        consume();
    }

    private void consume() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer val = queue.poll();
                System.out.println(Thread.currentThread().getName() + ": Received value: " + val);
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
