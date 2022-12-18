package com.coursera.algotoolbox;

import java.util.Scanner;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
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
        long n = scanner.nextLong();
//        long s = getFibonacciSumNaive(n);
//        System.out.println(s);
        System.out.println(getFibbonacciSum(n));
//        stressTest();
    }

    private static void stressTest(){

        for(int i=0; i<40;i++){
            long naiveSolution = getFibonacciSumNaive(i);
            long solution = getFibbonacciSum(i);
            System.out.println("Naive: " + naiveSolution + ", solution: " + solution + " for n = " + i);
            if(naiveSolution != solution)
                break;
        }
    }
}

