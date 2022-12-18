package practice.codechef;

import java.util.Scanner;

public class JULY20BCHEFSTR1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        for (int i = 0; i < testCount; i++) {
            int n = sc.nextInt();
            int[] strings = new int[n];
            for (int j = 0; j < n; j++) {
                strings[j] = sc.nextInt();
            }
            solve(strings);
        }
    }

    private static void solve(int[] strings) {
        int skippedStrings =0;
        for (int i = 1; i < strings.length; i++) {
        }
        System.out.println(skippedStrings);
    }
}
