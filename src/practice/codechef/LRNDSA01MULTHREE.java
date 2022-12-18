package practice.codechef;

import java.util.Scanner;

public class LRNDSA01MULTHREE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();

        for (int i = 0; i < testCount; i++) {
            int  a, b;
            long n;
            n = sc.nextLong();
            a = sc.nextInt();
            b = sc.nextInt();
            solve(a,b,n);
        }
    }

    private static void solve(int a, int b, long n){
        int sum = a + b;
        if(sum%3==0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static int getDigitSum(int n){
        int sum = 0;
        if(n < 10){
            return n;
        }
        while(n > 0){
            sum += n%10;
            n/=10;
        }
        return sum;
    }
}
