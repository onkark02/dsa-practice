package com.coursera.algotoolbox;

import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            long temp = previous;
            previous = current;
            current = temp + current;
        }

        return (int) (current % 10);
    }

    private static int getFibonacciLastDigit(int n){
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 2; i <= n; ++i) {
            int temp = previous;
            previous = current;
            current = (temp + current) % 10;
        }

        return current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
/*        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
        System.out.println("-----------");*/
        System.out.println(getFibonacciLastDigit(n));
    }
}

