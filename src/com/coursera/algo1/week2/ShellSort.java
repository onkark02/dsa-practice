package com.coursera.algo1.week2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class ShellSort {
    public static void sort(Comparable[] array){
        int h = 1;
        while(h < array.length){
            h=3*h+1; // 1, 4, 13, 40 etc.
        }
        while(h>=1){
            for(int i=h; i<array.length; i++){
                for(int j = i; j >= h && less(array[j],array[j-h]); j-=h)
                    swap(array, j, j-h);
            }
            h/=3;
        }
    }

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
    private static void swap(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[10000000];

        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(999999);
        }
        Stopwatch stopwatch = new Stopwatch();
        sort(a);
        System.out.println("time taken to sort array of "+ a.length +"is: "+ stopwatch.elapsedTime());
        //time taken to sort array of 10000000is: 24.846
        /*
        Stopwatch stopwatch1 = new Stopwatch();
        Arrays.sort(a);
        System.out.println("time taken to sort array of "+ a.length +" by arrays.sort is: "+ stopwatch1.elapsedTime());
        time taken to sort array of 10000000 by arrays.sort is: 4.281
        */
        boolean flag = false;
        for(int i=1; i<a.length; i++){
            if(a[i]<a[i-1]){
                flag = true;
                break;
            }
        }
        if(flag)
            System.out.println("not sorted");
        else
            System.out.println("Sorted");
    }
}
