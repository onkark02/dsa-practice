package practice.classic.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,4,5,6,2,5,2,5,7,2,4};
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("After sorting");
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr){
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int startIndex, int endIndex){
        //Base condition
        //Return if startIndex equals endIndex
        if(startIndex >= endIndex)
            return;

        //Get middle point to divide the input array
        int mid = startIndex + (endIndex-startIndex)/2;

        //Merge both subArrays recursively
        mergeSort(arr,startIndex,mid);
        mergeSort(arr,mid+1,endIndex);

        //Merge sorted subArrays
        merge(arr,startIndex,mid,mid+1,endIndex);
    }

    private static void merge(int[] arr, int startIndex1, int endIndex1, int startIndex2, int endIndex2) {
        int[] aux = new int[endIndex2-startIndex1+1];
        int i = 0, start = startIndex1;
        while(startIndex1<=endIndex1 && startIndex2<= endIndex2){
            if(arr[startIndex1] > arr[startIndex2]){
                aux[i++] = arr[startIndex2++];
            }else{
                aux[i++] = arr[startIndex1++];
            }
        }

        while(startIndex1 <= endIndex1){
            aux[i++] = arr[startIndex1++];
        }
        while(startIndex2 <= endIndex2){
            aux[i++] = arr[startIndex2++];
        }

        i=0;
        for(int j=start; i<aux.length; i++,j++)
            arr[j] = aux[i];
    }


}
