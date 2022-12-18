package practice.dsa;

public class ArrayQueue {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
    }

    int[] arr;
    int head, tail;

    public ArrayQueue(int size){
        if(size < 0)
            throw new IllegalArgumentException();
        arr = new int[size+1];
        head = 0;
        tail = 0;
    }

    public void enqueue(int x){
        if(tail+1% arr.length == head){
            System.out.println("Queue full");
            return;
        }
        arr[tail++] = x;
        if(tail==arr.length)
            tail = 0;
    }

    public int dequeue(){
        if(head+1 % arr.length == tail){
            System.out.println("Queue empty");
            throw new RuntimeException();
        }
        int x = arr[head++];
        if(head == arr.length)
            head = 0;
        return x;
    }

    public boolean isEmpty(){
        return head == tail;
    }
}
