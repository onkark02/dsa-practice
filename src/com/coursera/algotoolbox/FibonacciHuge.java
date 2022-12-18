package com.coursera.algotoolbox;

import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static long getFibbonacciHugeModulo(long n, long m){
        if(n < 2){
            return n;
        }

        long pisanoPeriod = getPisanoPeriod(m);

        long previous = 0;
        long current = 1;

        n = n%pisanoPeriod;

        if(n < 2){
            return n;
        }
        for(int i=2; i<=n; i++){
            long temp = previous;
            previous = current;
            current = (current+temp) % m;
        }

        return current;
    }

    private static long getPisanoPeriod(long m) {
        long previous = 0;
        long current = 1;

        for(int i=0; i<m*m; i++){
            long temp = previous;
            previous = current;
            current = (temp+current)%m;

            if(previous == 0 && current == 1)
                return i+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
//        System.out.println(getFibonacciHugeNaive(n, m));
        System.out.println(getFibbonacciHugeModulo(n,m));
//        stressTest();
    }

    private static void stressTest(){
        int nRange = 20;
        int mRange = 100;

        while(true){
            int n = new Random().nextInt(nRange) + 1;
            int m = new Random().nextInt(mRange) + 1;

            long naiveSolution = getFibonacciHugeNaive(n,m);
            long solution = getFibbonacciHugeModulo(n,m);
            System.out.println("Naive: " + naiveSolution + ", solution: "+ solution);
            if(naiveSolution != solution)
                break;
        }
    }
}

