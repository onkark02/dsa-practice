package practice.leetcode;

import java.util.Arrays;

//Given a sorted array and number k, find the number of occurrences of k in array
//in log(N) time
public class FrequencyInSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,2,5,2,6,2,6,8,3,8,3,2,5,89,3,4,-1,5,6,7,8,7,6,5,4,3,2,3,5,6,7,3,2};
        Arrays.sort(arr);
        System.out.println(getFrequency(arr,89));
    }

    public static int getFrequency(int[] arr, int k){
        int first = getFirstOccurrenceIndex(arr,k);
        if(first == -1)
            return 0;
        int last = getLastOccurrenceIndex(arr, k);
        return last-first+1;
    }

    private static int getFirstOccurrenceIndex(int[] arr, int k){
        int start=0, end=arr.length-1;
        int mid;
        while(start <= end){
            mid = start + (end-start)/2;
            if(arr[mid]==k && (mid==0 || arr[mid-1] != k)){
                return mid;
            }else if(arr[mid] < k){
                start = mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }

    private static int getLastOccurrenceIndex(int[] arr, int k){
        int start=0, end=arr.length-1;
        int mid;
        while(start <= end){
            mid = start + (end-start)/2;
            if(arr[mid]==k && (mid==arr.length-1 || arr[mid+1] != k)){
                return mid;
            }else if(arr[mid] > k){
                end = mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
}
