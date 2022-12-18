package com.coursera.algotoolbox.week5;

import java.util.Scanner;

public class ChangeDP {
    private static int[] coins = {1,3,4};
    private static int getChange(int m) {
        //write your code here
        int[] change = new int[m+1];
        for(int i=1; i<= m; i++){
            int minCoin = Integer.MAX_VALUE;
            for(int coin: coins){
                if(i >= coin && change[i-coin]+1 < minCoin){
                    minCoin = change[i-coin]+1;
                }
            }
            change[i] = minCoin;
        }
        return change[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

