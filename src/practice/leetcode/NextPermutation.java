package practice.leetcode;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1,3,2};
        nextPermutation(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static void nextPermutation(int[] nums) {
        int index=-1;
        for(index=nums.length-1; index>0; index--){
            if(nums[index-1] < nums[index])
                break;
        }

        if(index>0){
            int val = nums[index-1];
            for(int i=nums.length-1; i >= index; i--){
                if(nums[i] > val){
                    nums[index-1] = nums[i];
                    nums[i] = val;
                    break;
                }
            }
        }

        int left = index, right=nums.length-1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
/*    public static void nextPermutation(int[] nums) {
        if(nums==null || nums.length < 2)
            return;

        boolean isDescendingSorted = true;
        for(int i=nums.length-1; i>0; i--){
            if(nums[i] > nums[i-1]){
                isDescendingSorted = false;
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
                sort(nums,i,nums.length);
                break;
            }
        }

        if(isDescendingSorted){
            sort(nums,0,nums.length);
        }
    }*/

    private static void sort(int[] arr, int start, int end){
        Arrays.sort(arr,start,end);
    }
}
