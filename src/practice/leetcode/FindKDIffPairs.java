package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindKDIffPairs {
    public static void main(String[] args) {
        int[] nums = {3,1,1,5,4};
        System.out.println(findPairs(nums,2));
    }
    //Using 2 pointer
    public static int findPairs2Pointer(int[] nums, int k){
        return 0;
    }
    //Using hashmap
    public static int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums)
            map.put(num,map.getOrDefault(num,0)+1);

        int count=0;
        for(int num:nums){
            if(map.get(num)==null)
                continue;
            if(k!=0) {
                int t1 = num + k;
                int t2 = num - k;
                if (map.get(t1) != null)
                    count++;
                if (map.get(t2) != null)
                    count++;
            }else{
                if(map.getOrDefault(num,0) > 1)
                    count++;
            }
            map.remove(num);
        }
        return count;
    }
}
