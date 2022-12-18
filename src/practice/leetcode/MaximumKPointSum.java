package practice.leetcode;

public class MaximumKPointSum {
    public static void main(String[] args) {
        int[] nums = {9,7,7,9,7,7,9};
        System.out.println(maxScore(nums,7));
    }
    //Solve by minimizing remaining part of array
    public static int maxScore(int[] cardPoints, int k) {
        int totalSum = 0;

        for(int i=0; i<cardPoints.length; i++){
            totalSum+= cardPoints[i];
        }

        int rem = cardPoints.length-k;
        int remSum=0;
        for(int i=0; i<rem; i++){
            remSum+=cardPoints[i];
        }
        int minRemSum = remSum;

        for(int i=rem,j=0; i<cardPoints.length; i++,j++){
            remSum = remSum - cardPoints[j] + cardPoints[i];
            if(remSum < minRemSum)
                minRemSum = remSum;
        }

        return totalSum-minRemSum;
    }
    public static int maxScore1(int[] cardPoints, int k) {
        int maxSum=0;
        int sum=0;
        if(cardPoints==null || cardPoints.length==0 || k==0 || k>cardPoints.length){
            return maxSum;
        }

        for(int i=0; i<k; i++){
            maxSum+= cardPoints[i];
        }
        sum = maxSum;
        for(int i=k-1,j=cardPoints.length-1; i>=0; i--,j--){
            sum = sum - cardPoints[i] + cardPoints[j];
            if(maxSum < sum)
                maxSum = sum;
        }

        return maxSum;
    }
}
