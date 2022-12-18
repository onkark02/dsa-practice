package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,7,8,1};
        List<Integer> resultList = findDisappearedNumbers(nums);
        resultList.forEach(System.out::println);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        for(int j=0; j < nums.length; j++){
            while(nums[j]>0 && nums[j] <= nums.length && nums[j] != j+1 && nums[j] != nums[nums[j]-1]){
                int temp = nums[nums[j]-1];
                nums[nums[j]-1] = nums[j];
                nums[j] = temp;
            }
        }
        for(int i=0; i < nums.length; i++){
            if(nums[i] != i+1)
                resultList.add(i+1);
        }
        return resultList;
    }
}
