package com.coursera.algotoolbox.week5;

import java.util.*;

public class PrimitiveCalculator {
    /*
    * 1. Build an array of size n+1 which stores the number of operations to reach there from 1
    * 2. Now from n, start going back to find out the path which led to n in minimum steps
    * 3. reverse the path -> result
    * */
    private static List<Integer> optimalSequence(int n) {
        int[] optimalSteps = buildOptimalSequence(n);

        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            int minSteps=Integer.MAX_VALUE;
            int val = n;
            if (val % 3 == 0) {
                n = val/3;
                minSteps = optimalSteps[n];
            }
            if (val % 2 == 0 && optimalSteps[val/2]<minSteps) {
                n = val/2;
                minSteps = optimalSteps[n];
            }
            if(optimalSteps[val-1] < minSteps) {
                n =val- 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    private static int[] buildOptimalSequence(int n) {
        int[] sequence = new int[n+1];

        for(int i=1; i<=n; i++){
            int minSteps = sequence[i-1]+1;
            if(i%2==0 && minSteps > 1+sequence[i/2]){
                minSteps = 1+sequence[i/2];
            }
            if(i%3==0 && minSteps > 1+sequence[i/3]){
                minSteps = 1 + sequence[i/3];
            }

            sequence[i] = minSteps;
        }
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimalSequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

