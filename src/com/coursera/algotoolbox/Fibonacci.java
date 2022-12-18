package com.coursera.algotoolbox;

import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  private static long fibFaster(int n){
    long[] sum= new long[2];
    sum[0] = 0;
    sum[1] = 1;
    if(n < 2){
      return sum[n];
    }
    for(int i=2;i <= n; i++){
      long temp = sum[1];
      sum[1] = sum[1] + sum[0];
      sum[0] = temp;
    }
    return sum[1];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

/*    System.out.println(calc_fib(n));
    System.out.println("--------");*/
    System.out.println(fibFaster(n));
  }
}
