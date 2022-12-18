package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/maximum-erasure-value/
public class MaxErasureValue {

    public static void main(String[] args) {
        int[] nums = {2,3,1,5,6,4};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] A) {

        for(int index=0; index<A.length; index++){
            int j=index, val = A[index];
            while(val > 0 && val <= A.length && A[val-1] != val){
                int temp = A[val-1];
                A[val-1] = val;
                val = temp;
            }
        }

        int i =0;
        for(; i<A.length; i++){
            if(A[i] != i+1)
                break;
        }
        return i+1;
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0, j=0; i<nums.length; i++){
            currSum += nums[i];
            if(map.containsKey(nums[i])){
                if(map.get(nums[j]) <= map.get(nums[i])){
                    currSum = currSum - map.get(nums[j]);
                    j = i+1;
                }
            }
            map.put(nums[i], currSum);
            if(currSum > maxSum)
                maxSum = currSum;
        }

        return maxSum;
    }
}
