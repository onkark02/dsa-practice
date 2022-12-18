package practice.leetcode.sde;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {1,1,0,0};

        long sum = Long.MIN_VALUE;

        System.out.println("Before sort: "+ Arrays.toString(arr));
        sortColors(arr);
        System.out.println("After sort: "+ Arrays.toString(arr));
    }
         /*public void sortColors(int[] nums) {
        int[] numberOfOccurances = new int[3];
        for(int i=0; i<nums.length; i++)
            numberOfOccurances[nums[i]]++;
        for(int i=0, j=0; i<3; i++)
            while(numberOfOccurances[i]>0){
                nums[j++] = i;
                numberOfOccurances[i]--;
            }
    }*/


        public static void sortColors(int[] nums){
            int low = 0, ptr = 0, high = nums.length -1;
            while(ptr <= high){
                switch(nums[ptr]){
                    case 0:
                        swap(nums, ptr++, low++);
                        break;
                    case 1:
                        ptr++;
                        break;
                    case 2:
                        swap(nums, ptr, high--);
                        break;
                    default:
                        System.out.println("Invalid input provided");
                }
            }
        }

    private static void swap(int[] nums, int index1, int index2){
        if(index1 == index2)
            return;
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
