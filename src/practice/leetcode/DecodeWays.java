package practice.leetcode;

import java.util.Map;

public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();
        Map<Character, Integer> map;
        System.out.println(solution.numDecodings("2611055971756562"));
    }

    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        if(s.charAt(n-1) != '0')
            dp[n-1] = 1;

        for(int i=n-2; i>=0; i--){
            char digit = s.charAt(i);
            if(digit != '0'){
                int ways = dp[i+1];
                int number = Character.getNumericValue(digit) * 10 + Character.getNumericValue(s.charAt(i+1));
                if(number <= 26)
                    ways += dp[i+2];
                dp[i] = ways;
            }
        }

        return dp[0];
    }
}
