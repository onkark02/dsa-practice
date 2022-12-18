package practice.leetcode;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
//    private static List<Integer>[] dp;
    private static int[] lengthDp;
    public static int lengthOfLIS(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        dp = new List[nums.length];
        lengthDp = new int[nums.length];
        int res=0;
        for(int i=nums.length-1; i >= 0; i--){
           int longestSub = getLongestSubsequenceStartingAtIndex(nums,i);
            if(res < longestSub)
                res = longestSub;
        }
        return res;
    }

    private static int getLongestSubsequenceStartingAtIndex(int[] nums, int i) {
        if(lengthDp[i] == 0) {

            int longestNext = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] <= nums[i])
                    continue;
//                subsequence.add(nums[j]);
                int next = getLongestSubsequenceStartingAtIndex(nums, j);
//                subsequence.remove(subsequence.size() - 1);
                if (next > longestNext)
                    longestNext = next;
            }
//            longestNext.add(0,nums[i]);
//            res.addAll(longestNext);

            lengthDp[i] = longestNext+1;

        }
        return lengthDp[i];
    }
}
