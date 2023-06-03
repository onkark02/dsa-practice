package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeNumberCounter {
    private static final int MAX_VALUE =  50000000;
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger start = new AtomicInteger(1);
        AtomicInteger count = new AtomicInteger(0);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0; i<5; i++)
            executorService.submit(new PrimeCounter(MAX_VALUE,start,count));
//        executorService.submit(new PrimeCounter(MAX_VALUE,start,count));

        executorService.shutdown();
        System.out.println("Total count: "+count);
    }
}

class PrimeCounter implements Runnable{
    int maxValue;
    AtomicInteger currentValue;
    AtomicInteger count;

    public PrimeCounter(int maxValue, AtomicInteger currentValue, AtomicInteger count) {
        this.maxValue = maxValue;
        this.currentValue = currentValue;
        this.count = count;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while(true){
            int value = currentValue.incrementAndGet();
            if(value > maxValue){
                System.out.printf("%s completed in %d ms \n", Thread.currentThread().getName(),System.currentTimeMillis()-start);
                break;
            }
            if(isPrime(value)){
                //System.out.println(value);
                count.getAndIncrement();
            }
        }
        System.out.println("Count is: "+count);
    }

    private boolean isPrime(int value) {
        int count = 2;
        while(count <= Math.sqrt(value)){
            if(value % count == 0)
                return false;
            count++;
        }
        return true;
    }
}
