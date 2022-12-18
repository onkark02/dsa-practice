package practice.leetcode;

import java.util.Arrays;

//https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3258/
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {2,1,1};
        System.out.println("Length: "+removeDuplicates(arr));
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        int writePointer = 1;
        for(int readPointer=1; readPointer < nums.length; readPointer++){
            if(nums[readPointer] != nums[readPointer-1]){
                nums[writePointer] = nums[readPointer];
                writePointer++;
            }
        }
        return writePointer;
    }
}
