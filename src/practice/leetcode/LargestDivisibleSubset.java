package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {5,9,18,54,108,540,90,180,360,720};
        System.out.println(largestDivisibleSubset(nums));
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();

        List<List<Integer>> results = new ArrayList<>();

        if(nums != null && nums.length > 0){
            Arrays.sort(nums);
            for(int num:nums){
                boolean added = false;
                for(List<Integer> list: results){
                    if(!list.isEmpty() && num % list.get(list.size()-1)==0){
                        list.add(num);
                        added = true;
                        if(list.size() > result.size())
                            result = list;
                    }
                }
                if(!added){
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    results.add(list);
                }
            }
        }

        return result;
    }
}
