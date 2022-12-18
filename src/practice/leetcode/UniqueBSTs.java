package practice.leetcode;

public class UniqueBSTs {
    public static void main(String[] args) {
        UniqueBSTs soluion = new UniqueBSTs();
        System.out.println(soluion.numTrees(3));
    }

    int[] dp;
    public int numTrees(int n) {
        dp = new int[n+1];
        dp[0] = 1;
        return getTreeNum(n);
    }

    private int getTreeNum(int n){
        if(dp[n] == 0){
            int sum=0;
            for(int i=1; i<=n; i++){
                int leftPart = i-1;
                int rightPart = n-i;
                sum += getTreeNum(leftPart)*getTreeNum(rightPart);
            }
            dp[n] = sum;
        }
        return dp[n];
    }
}
