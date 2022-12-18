package practice.classic;

public class KadaneAlgo {
    public static void main(String[] args) {
        int[] arr = {-7, -8, -16, -4, -8, -5, -7, -11, -10, -12, -4, -6, -4, -16, -10 };
        maxSubarraySum(arr,arr.length);
    }



        public static long maxSubarraySum(int[] arr, int n) {
            // write your code here
            long maxGlobalSum = 0;
            long localSum = Integer.MIN_VALUE;

            for(int i=0; i<arr.length; i++){
                localSum = Math.max(localSum + arr[i],arr[i]);
                maxGlobalSum = Math.max(maxGlobalSum, localSum);
            }

            return maxGlobalSum;
        }

}
