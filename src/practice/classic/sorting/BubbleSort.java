package practice.classic.sorting;

public class BubbleSort {
    public static void sort(int[] arr){
        boolean swapped = true;
        for(int l=arr.length-1; l > 0 && swapped; l--){
             swapped = false;
            for(int i=0; i < l; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
}
