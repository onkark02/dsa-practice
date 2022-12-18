package practice.classic;

import java.util.Random;

public class QuickSelect {
    public static void main(String[] args) {
        int[] arr = {2,34,5,3,1,6,2,4,8,22};
        System.out.println(quickSelect(arr,10));
    }

    //Method to find Kth maximum element from array
    public static int quickSelect(int[] arr, int k){
        if(k>arr.length)
            return -1;
    int start = 0, end = arr.length-1;
    int requiredIndex = arr.length-k;
    while(start <= end){
        int pivot = partition(arr,start,end);
        if(pivot == requiredIndex){
            return arr[pivot];
        }else if(pivot<requiredIndex){
            start = pivot+1;
        }else{
            end = pivot-1;
        }
    }
    return -1;
    }

    private static int partition(int[] arr, int start, int end){
        //Randomizing pivot value selection for handling specific worst case running time
        int randomIndex = start + new Random().nextInt(end+1-start);
        swap(arr,randomIndex,end);

        int pivotValue=arr[end];
        int left=start;
        for(int i=start; i<end;i++){
            if(arr[i]<pivotValue){
                swap(arr,left++,i);
            }
        }
        swap(arr,left,end);
        return left;
    }

    private static void swap(int[] arr,int i1,int i2){
        if(i1 != i2){
            int temp = arr[i1];
            arr[i1] = arr[i2];
            arr[i2]=temp;
        }
    }
}
