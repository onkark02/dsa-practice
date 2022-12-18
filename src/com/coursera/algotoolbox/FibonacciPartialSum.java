package com.coursera.algotoolbox;

import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    private static long getFibonacciPartialSum(long from, long to){
        long fromSum = 0;
        if(from > 1){
            fromSum = getFibbonacciSum(from-1);
        }
        long toSum = getFibbonacciSum(to);
        return (toSum - fromSum + 10) % 10;
    }

    private static long getFibbonacciSum(long n){
        long fibbonacciNumModulo10 = getFibbonacciHugeModulo(n+2,10);
        return (fibbonacciNumModulo10 + 9) % 10;
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
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        //System.out.println(getFibonacciPartialSumNaive(from, to));
        System.out.println(getFibonacciPartialSum(from,to));
//        stressTest();
    }

    private static void stressTest(){
        int nRange = 20;


        while(true){
            int n = new Random().nextInt(nRange) + 1;
            int m = new Random().nextInt(n) + 1;

            long naiveSolution = getFibonacciPartialSumNaive(m,n);
            long solution = getFibonacciPartialSum(m,n);
            System.out.println("N: " + n + " M: " + m);
            System.out.println("Naive: " + naiveSolution + ", solution: "+ solution);
            if(naiveSolution != solution)
                break;
        }
    }
}

