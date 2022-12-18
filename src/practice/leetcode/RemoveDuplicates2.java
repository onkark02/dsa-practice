package practice.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDuplicates2 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        System.out.println("Length: "+removeDuplicates(arr));
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j=0; j<nums.length; j++)
            if (i < 2 || nums[j] > nums[i - 2])
                nums[i++] = nums[j];
        return i;
    }
/*    public static int removeDuplicates(int[] nums) {
        int ptr=0, nextPtr=1;

        while(nextPtr<nums.length){
            while(nextPtr<nums.length &&nums[nextPtr]==nums[nextPtr-1])
                nextPtr++;
            //if()
            if(nextPtr<nums.length)
                nums[++ptr]=nums[nextPtr++];
        }
       *//* while(nextPtr < nums.length){
            while(nums[nextPtr]==nums[nextPtr-1])
                nextPtr++;
            if(nums[ptr]==nums[ptr-1])
                ptr++;
            if(nextPtr!=ptr){
                nums[ptr] = nums[nextPtr];
                nums[nextPtr] = -1;
            }
            nextPtr++;
            ptr++;
        }*//*
        return ptr+1;
    }*/
}
