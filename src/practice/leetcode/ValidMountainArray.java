package practice.leetcode;

public class ValidMountainArray {
    public static void main(String[] args) {
        int[] arr = {0,3,2,1};
        System.out.println(validMountainArray(arr));
    }
    public static boolean validMountainArray(int[] arr) {
        boolean isValidMountain = true, isIncreasing = true;
        for (int i=1; i<arr.length; i++){
            if(isIncreasing){
                if(arr[i] <= arr[i-1]){
                    if(i != 1 && arr[i] < arr[i-1]){
                        isIncreasing = false; //Reversal of slope of mountain array
                    }else{
                        isValidMountain = false;
                        break;
                    }
                }
            }else {
                if(arr[i] >= arr[i-1]){
                    isValidMountain = false;
                    break;
                }
            }
        }
        return isValidMountain && !isIncreasing;
    }
}
