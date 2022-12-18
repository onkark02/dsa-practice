package practice.leetcode;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args) {
        int[] arr = {2,2,6};
        System.out.println(getTriangleNo(arr));
    }

    public static int getTriangleNo(int[] arr){
        int total = 0;
        if(arr == null || arr.length < 3)
            return total;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                int k = j+1;
                int sum = arr[i] + arr[j];
                int index = getValidIndex(arr, k,arr.length-1, sum);
                if(arr[index] >= sum){
                    index--;
                }

                if(index>=k){
                    total+= index-k+1;
                }
            }
        }

        return total;
    }

    private static int getValidIndex(int[] arr, int start, int end, int val){
        int mid = 0;
        while(start <= end){
            mid = start + (end-start)/2;
            if(arr[mid] == val){
                break;
            }else if(val < arr[mid]){
                end = mid - 1;
            }else {
                start = mid +1;
            }
        }
        return mid;
    }
}
