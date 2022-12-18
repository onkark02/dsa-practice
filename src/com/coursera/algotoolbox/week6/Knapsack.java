package com.coursera.algotoolbox.week6;

import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {


        return 0;
    }

    static int[][] matrix;
    static int optimalWeightRecursive(int W, int[] w, int index){
        int value = 0;
        if(matrix[index+1][W] != 0)
            return matrix[index][W];
        if(index > -1) {
            if (W >= w[index]) {
                value = Math.max(optimalWeightRecursive(W, w, index - 1), optimalWeightRecursive(W-w[index], w, index - 1)+w[index]);
            } else {
                value = optimalWeightRecursive(W, w, index - 1);
            }
        }
        matrix[index+1][W] = value;
        return matrix[index+1][W];
    }

    public static void main(String[] args) {
        mainCode();
//        stressTest();
    }

    private static void mainCode(){
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
//        System.out.println(optimalWeight(W, w));
        matrix = new int[w.length+1][W+1];
        System.out.println(optimalWeightRecursive(W,w,w.length-1));
    }


    private static void stressTest(){

    }
}

