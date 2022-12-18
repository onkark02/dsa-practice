package com.coursera.algotoolbox.week4;

import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
      //write your code here
      int m1 = l;
      int m2 = r+1;
      int index=l+1, pivot = a[l];
 /*       System.out.println("Partition element: "+pivot);
        for(int i:a){
            System.out.print(i + " ");
        }*/
      while(index < m2){
          if(a[index] < pivot){
              swap(a,index++,m1++);
          }else if(a[index] > pivot){
              swap(a,index,--m2);
          }else{
              index++;
          }
      }
/*        System.out.println("After partition");
        for(int i:a){
            System.out.print(i + " ");
        }*/
      int[] m = {m1, m2-1};
      return m;
    }

    private static void swap(int[] a, int i, int j){
        if(i == j)
            return;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }





    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        //int m = partition2(a, l, r);
        int[] m =partition3(a,l,r);
        randomizedQuickSort(a, l, m[0] - 1);
/*        if(r == a.length-1){
            System.out.println("--------");
        }*/
        randomizedQuickSort(a, m[1] + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        //System.out.println("Result \n");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        //while (stressTest());
    }

    private static boolean stressTest(){
        int[] arr = {5,5,5,5,5,5,5,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        System.out.println("Before test");
        randomizedQuickSort(arr,0,arr.length-1);
        System.out.println("Result: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if(i>0 && arr[i]<arr[i-1])
                return false;
        }
        return true;
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

