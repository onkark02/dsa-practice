package com.coursera.algo1.week2.assignment;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rQueue = new RandomizedQueue<>();
//        System.out.println("args: "+ args.length);
        while(!StdIn.isEmpty()){
            rQueue.enqueue(StdIn.readString());
        }
    /*    for(int i=1; i< args.length; i++){
            rQueue.enqueue(args[i]);
        }*/
        for (int i = 0; i <k ; i++) {
            System.out.println(rQueue.dequeue());
        }
    }
}
