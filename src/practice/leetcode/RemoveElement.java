package practice.leetcode;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {2,2,2};
        int length = removeElement(arr,2);
        System.out.println("Length: "+ length);
        Arrays.stream(arr).forEach(System.out::println);
    }

/*    private static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }*/


    //My solution
    private static int removeElement(int[] nums, int val) {
        int ptr=0, reversePtr = nums.length - 1;
        while (ptr <= reversePtr){
            while (reversePtr > -1 && nums[reversePtr] == val){
                reversePtr--;
            }
            if(ptr >= nums.length || reversePtr < 0)
                break;
            if(nums[ptr] == val){
                nums[ptr] = nums[reversePtr];
                nums[reversePtr] = val;
            }else{
                ptr++;
            }
        }
        return ptr;
    }
}
