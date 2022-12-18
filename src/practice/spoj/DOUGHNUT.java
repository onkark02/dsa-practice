package practice.spoj;

import java.util.Scanner;

public class DOUGHNUT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTests = scanner.nextInt();
        int c, k, w;
        for (int i = 0; i < noOfTests; i++) {
            c = scanner.nextInt();
            k = scanner.nextInt();
            w = scanner.nextInt();
            solve(c,k,w);
        }
    }
    private static void solve(int c, int k, int w){
        if(c*w <= k)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
