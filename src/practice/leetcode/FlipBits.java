package practice.leetcode;

public class FlipBits {
    public static void main(String[] args) {
     int[] arr = {0, 1, 0, 0, 1, 1, 0};
        System.out.println(flipBits(arr,arr.length));
    }
    public static int flipBits(int[] arr,int n) {
        //Write your code here
        int maxDiff = 0, currDiff = 0, count1 = 0;

        for(int i=0; i<n; i++){
            if(arr[i]==1)
                count1++;
            int val = (arr[i]==1) ? -1:1;
            currDiff = Math.max(val, currDiff+val);
            maxDiff = Math.max(maxDiff, currDiff);
        }

        return count1 + maxDiff;
    }
}
