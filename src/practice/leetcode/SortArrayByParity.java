package practice.leetcode;

import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {

        int[] arr = {3,1,2,4};
        sortArrayByParity(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sortArrayByParity(int[] arr) {
        int evenPointer = 0, oddPointer = arr.length-1;
        while(evenPointer < oddPointer){
            if(arr[evenPointer]%2 == 0){
                evenPointer++;
            }else{
                if(arr[oddPointer]%2 != 0){
                    oddPointer--;
                }else{
                    int temp = arr[evenPointer];
                    arr[evenPointer] = arr[oddPointer];
                    arr[oddPointer] = temp;
                    evenPointer++;
                    oddPointer--;
                }
            }
        }
    }
}
