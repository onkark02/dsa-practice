package practice.leetcode;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        RotateArray test = new RotateArray();
        test.rotate(nums, 2);
        //test.reverse(nums,0,4);
        Arrays.stream(nums).forEach(System.out::println);
    }
    //Approach 1: Using extra array
    /*
    public void rotate(int[] nums, int k) {
        int[] rotatedArray = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            rotatedArray[(i+k)%nums.length] = nums[i];
        }
        for(int i=0; i<nums.length; i++){
            nums[i] = rotatedArray[i];
        }
    }
    */

    //Approach 2: Without using extra array, rotating by 1
    /*
    public void rotate(int[] nums, int k) {
        for(int i=0; i<k; i++)
            rotate(nums);
     }

    private void rotate(int[] nums){
        int i=0, prev=nums[0];
        for(; i<nums.length-1; i++){
            int temp = nums[i+1];
            nums[i+1] = prev;
            prev = temp;
        }
        nums[0] = prev;
    }
    */

    //Approach 3: Without using extra array, rotating by k
    public void rotate(int[] nums, int k){
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
