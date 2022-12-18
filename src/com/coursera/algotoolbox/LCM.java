package com.coursera.algotoolbox;

import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long gcd(long a, long b){
    if(a % b == 0){
      return b;
    }else{
      return gcd(b,a%b);
    }
  }

  private static long lcm(int a, int b){
    long gcd = gcd(a,b);
    return (a * (long)b)/gcd;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
/*    System.out.println(lcm_naive(a, b));
    System.out.println("---------");*/
    System.out.println(lcm(a,b));
//    stressTest(1000 );
  }
  private static void stressTest(int n){
    while(true){
      int a = new Random().nextInt(n) + 1;
      int b = new Random().nextInt(a) + 1;
      long res1 = lcm_naive(a,b);
      long res2 = lcm(a,b);
      System.out.println("Input: "+a+", "+b);
      System.out.println("Output: "+res1+", "+res2);
      if(res1 != res2)
        break;
    }
  }
}
