package com.coursera.algo1.week3;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
    public static int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        Comparable key = a[lo++];
        while(lo <= hi){
            while(lo <= hi && isLess(a[lo], key)){
                lo++;
            }
            while(lo <= hi && isLess(key, a[hi])){
                hi--;
            }
            swap(a, lo, hi);
        }
        swap(a, i, lo);
        return lo;
    }
    private static boolean isLess(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
    private static void swap(Comparable[] array, int a, int b){
        Comparable temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    private static void sort(Comparable[] a, int lo, int hi){
        if(lo >= hi)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1,hi);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniform(arr.length);
        }
        for (int i:
                arr) {
            System.out.println(i);
        }
        System.out.println("#########################################################");
        sort(arr, 0, arr.length-1);

        for (int i:
             arr) {
            System.out.println(i);
        }
    }
}
