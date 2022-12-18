package practice.classic.sorting;

import java.time.Duration;
import java.time.Instant;

public class SortTester {
    public static void main(String[] args) {
        int size = 9000000;

        //Create test array
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = (int) (Math.random()*size);
        }
        //Sort array
        Instant start = Instant.now();

        //Java's sorting implementation
//        Arrays.sort(arr);
//
//        //My merge sort impl
 //     MergeSort.mergeSort(arr);
//
//        //My insertion sort impl
//        InsertionSort.insertionSort(arr);

        //My QuickSort impl
//        QuickSort.sort(arr);

        //Selection sort impl
//        SelectionSort.sort(arr);

        //Bubble sort
        BubbleSort.sort(arr);

        Instant end = Instant.now();

        //Test sorting
        System.out.println("Time taken: " + Duration.between(start,end).toString());

        System.out.println("Sorted successfully: " + testSortedArray(arr));
    }
    private static boolean testSortedArray(int[] arr){
        for(int i=1; i<arr.length; i++){
            if(arr[i] < arr[i-1])
                return false;
        }
        return true;
    }
}
