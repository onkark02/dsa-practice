package com.coursera.algo1.misc;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        List<Integer> list = Arrays.asList(1,2,3,4,5);
/*        for(int n: list){
            System.out.println("This is :"+n);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        int d = 5/0;
        list.stream().forEach(n ->{
            System.out.println("This is :"+n);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Total time: "+ stopwatch.elapsedTime());
    }
}
