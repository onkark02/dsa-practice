package com.coursera.algotoolbox.week5;

import java.util.Random;
import java.util.Scanner;

public class LCS2 {

    /*
    * This distance matrix is different than edit distance problem
    * Here mismatches are not allowed, so that we can derive commmon subsequence or its length
    * */
    public static int[][] getDistanceMatrix(int[] s, int[] t) {
        //write your code here
        int[][] distances = new int[1+s.length][1+t.length];
        //Set first column of matrix
        for(int i=0;i<distances.length; i++){
            distances[i][0] = i;
        }
        //Set first row of matrix
        for(int i=0; i<distances[0].length;i++){
            distances[0][i] = i;
        }

        //Start filling matrix row by row (can be done column wise as well)
        for(int i=1; i<distances.length;i++){
            for(int j=1;j<distances[i].length;j++){
                boolean isMatch = s[i-1] == t[j-1];
                int minDistance = Math.min(distances[i][j-1]+1,distances[i-1][j]+1);
                int diagonalDistance = isMatch ? distances[i-1][j-1]:Integer.MAX_VALUE; //This is to not allow mismatches
                distances[i][j] = Math.min(minDistance,diagonalDistance);
            }
        }
        return distances;
    }

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        int[][] matrix = getDistanceMatrix(a,b);
        int editDistanceWithoutMismatch = matrix[a.length][b.length];
        int distanceForAllSeparateChars = a.length + b.length;
        int subSequenceLength = (distanceForAllSeparateChars - editDistanceWithoutMismatch)/2; //Divided by 2, as the difference between these two would be twice the common chars
        return subSequenceLength;
    }

    private static int[][] dp;

    private static int lcs2Recursive(int[] a, int[] b, int l1, int l2){
        if(l1==a.length && l2==b.length){
            dp = new int[l1+1][l2+1];
        }

        if(l1 < 1 || l2 <1){
            return 0;
        }
        if(dp[l1][l2] == 0) {
            int lcs;
            if (a[l1 - 1] == b[l2 - 1]) {
                lcs = 1 + lcs2Recursive(a, b, l1 - 1, l2 - 1);
            } else {
                lcs = Math.max(lcs2Recursive(a, b, l1, l2 - 1), lcs2Recursive(a, b, l1 - 1, l2));
            }
            dp[l1][l2] = lcs;
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        //main();
        stressTest(20);
    }

    private static void main(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
        System.out.println(lcs2Recursive(a,b,a.length,b.length));
    }

    private static void stressTest(int n){
        int[] a = new int[n];
        int[] b = new int[n];
        int count=0;
        while (true){
            System.out.println("Count: "+count++);
          for(int i=0; i<n; i++){
              a[i] = new Random().nextInt(100);
              b[i] = new Random().nextInt(100);
          }
          int sol1 = lcs2(a,b);
          int sol2 = lcs2Recursive(a,b,n,n);

          if(sol1 != sol2){
              System.out.println("Solutions not matching, sol1: "+sol1+", sol2: "+sol2);
              for(int i=0; i<n; i++){
                  System.out.print(a[i] + " ");
              }
              System.out.println("------------------------");
              for(int i=0; i<n; i++){
                  System.out.print(b[i] + " ");
              }
              break;
          }
        }
    }
}

