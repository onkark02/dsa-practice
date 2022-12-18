package practice.classic.sorting;

public class QuickSort {

    public static void sort(int[] arr){
        if(arr != null) {
            quickSort(arr, 0, arr.length - 1);
        }
    }
    private static void quickSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        //Get pivot index
        int pivotIndex = partition(arr,start,end);

        //Quick sort recursively
        quickSort(arr,start,pivotIndex-1);
        quickSort(arr,pivotIndex+1,end);
    }
    private static int partition(int[] arr, int start, int end){
        int pivotValue = arr[end];
        int pivotIndex = start;

        for(int i=start;i<end;i++){
            if(arr[i] < pivotValue){
                swap(arr,i,pivotIndex);
                pivotIndex++;
            }
        }
        swap(arr,pivotIndex,end);
        return pivotIndex;
    }
    private static void swap(int[] arr, int index1, int index2){
        if(index1 != index2){
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }
}
