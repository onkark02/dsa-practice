package com.coursera.algotoolbox.week3;

import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        sortValuesAnsWeights(values,weights);
        int i=0;
        while (capacity > 0 && i < weights.length){
               int weight = Math.min(capacity,weights[i]);
               capacity -= weight;
               value += weight*(values[i]/(double)weights[i]);
               i++;
        }
        return value;
    }

    private static void sortValuesAnsWeights(int[] values, int[] weights){
        for(int i=1; i<values.length; i++){
            int j=i;
            int value = values[j];
            int weight = weights[j];
            double ratio = value/(double)weight;
            while(--j>=0 && ratio > (values[j]/(double)weights[j])){
                values[j+1] = values[j];
                weights[j+1] = weights[j];
            }
            values[j+1] = value;
            weights[j+1] = weight;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
