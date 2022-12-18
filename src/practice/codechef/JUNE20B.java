package practice.codechef;

import java.util.Scanner;

public class JUNE20B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        for (int i = 0; i < testCount; i++) {
            int n, k;
            int[] numbers;
            n = sc.nextInt();
            k = sc.nextInt();
            numbers = new int[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = sc.nextInt();
            }
            solve(n,k,numbers);
        }
    }

    private static void solve(int n, int k, int[] numbers){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(numbers[i] > k)
                sum += numbers[i] -k;
        }
        System.out.println(sum);
    }
}
