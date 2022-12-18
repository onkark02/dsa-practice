package com.coursera.algotoolbox.week4;

import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right == left) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave+1, right);
        //write your code here
        int l = left, r = ave+1,k=left;

        while(l <= ave && r <=right){
            if(a[l] <= a[r]){
                b[k++] = a[l++];
            }else{
                b[k++] = a[r++];
                numberOfInversions += (ave+1-l);
            }
        }
        while(l <= ave){
            b[k++] = a[l++];
        }
        while(r <=right){
            b[k++] = a[r++];

        }
        for(int i=left; i<=right; i++)
            a[i] = b[i];
        return numberOfInversions;
    }

    private static long getNumberOfInversionsNaive(int[] a){
        int numberOfInversions = 0;
        for(int i=0; i<a.length; i++){
            for(int j=i+1; j<a.length; j++){
                if(a[j] < a[i])
                    numberOfInversions++;
            }
        }
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length-1));
//        stressTest(100);
    }

    private static void stressTest(int n){
        while(true) {
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = new Random().nextInt(100);
            }
            int[] b = new int[n];
            for(int i=0; i<a.length;i++)
                System.out.print(a[i]+ " ");
            long res2 = getNumberOfInversionsNaive(a);
            long res1 = getNumberOfInversions(a,b,0,a.length-1);

            System.out.println("Result: "+res1+", result naive: "+res2);
            if(res1 != res2){
                break;
            }
         }
    }
}

