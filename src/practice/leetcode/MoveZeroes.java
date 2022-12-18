package practice.leetcode;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
            int[] arr = {0,1,0,3,12};
            moveZeroes(arr);
            Arrays.stream(arr).forEach(System.out::println);
        }

    public static void moveZeroes(int[] nums) {
        int nonZeroPointer=0;
        for (int pointer=0; pointer < nums.length; pointer++){
            if(nums[pointer] != 0){
                if(pointer != nonZeroPointer){
                nums[nonZeroPointer] = nums[pointer];
                nums[pointer] = 0;
                }
                nonZeroPointer++;
            }
        }
    }
}
