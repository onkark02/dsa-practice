package com.coursera.algotoolbox.week6;

import java.util.Scanner;

public class Partition3 {
    private static int partition3(int[] A) {
        //write your code here
        if(A.length < 3)
            return 0;
        int sum = 0;
        for(int i=0; i<A.length; i++)
            sum += A[i];
        if(sum%3 != 0)
            return 0;
        int[] used = new int[A.length];

        if(partitionk(A,used, 3,sum/3,0)){
            for(int k=1; k<4;k++){
                System.out.print("K= "+k+": ");
                for(int i=0; i<used.length; i++)
                    if(used[i] == k)
                        System.out.print(A[i] + " ");
                System.out.println();
            }
            return 1;
        }
        return 0;
    }

    private static boolean partitionk(int[] nums, int[] used, int k, int sum, int currentSum){
        //No buckets left
        if(k==0)
            return true;
        //If sum is matching, reduce bucket count k
        if(currentSum == sum){
            return partitionk(nums,used,k-1,sum,0);
        }

        for(int i=0; i<nums.length; i++){
            if(used[i] == 0 && currentSum+nums[i] <= sum){
                used[i] = k;
                if(partitionk(nums,used,k,sum,currentSum+nums[i]))
                    return true;
                used[i] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

