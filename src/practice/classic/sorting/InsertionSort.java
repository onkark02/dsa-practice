package practice.classic.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {3,3,3,3,4,4,4};
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After sorting");
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr){
        for(int i=1; i < arr.length; i++){
            int j = i-1;
            int val = arr[i];
            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            while(j >= 0 && arr[j] > val){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = val;
        }
    }
}
