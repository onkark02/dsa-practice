package com.coursera.algotoolbox.week3;

import java.util.Scanner;

public class Change {
    private static final int[] allowedDenominations = {1,5,10};

    private static int getChange(int m) {
        //write your code here
        int coinCount = 0;
        for(int i=allowedDenominations.length-1; i>=0; i--){
            int coin = allowedDenominations[i];
            if(m>=coin){
                coinCount += m/coin;
                m = m%coin;
            }
        }
        return coinCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

