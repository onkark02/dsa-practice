package practice.leetcode;

import java.util.Arrays;

//https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/
public class ReplaceElements {
    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        replaceElements(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public  static int[] replaceElements(int[] arr) {
        int maxToRight = -1;
        for(int i=arr.length-1; i > -1; i--){
            if(i==arr.length-1){
                maxToRight = arr[i];
                arr[i] = -1;
            }else{
                int tempMax = maxToRight;
                if(maxToRight < arr[i]){
                    maxToRight = arr[i];
                }
                arr[i] = tempMax;
            }
        }
        return arr;
    }
}
