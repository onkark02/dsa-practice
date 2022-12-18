package com.coursera.algotoolbox;

import java.util.Random;
import java.util.Scanner;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  private static int gcd(int a, int b){
    if(a % b == 0){
      return b;
    }else{
      return gcd(b,a%b);
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

/*    System.out.println(gcd_naive(a, b));
    System.out.println("-----------");*/

    System.out.println(gcd(a,b));

//    stressTest(1000);
  }

  private static void stressTest(int n){
    while(true){
      int a = new Random().nextInt(n) + 1;
      int b = new Random().nextInt(a) + 1;
      int res1 = gcd_naive(a,b);
      int res2 = gcd(a,b);
      System.out.println("Input: "+a+", "+b);
      System.out.println("Output: "+res1+", "+res2);
      if(res1 != res2)
        break;
    }
  }
}
