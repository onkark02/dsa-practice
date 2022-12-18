package practice.classic;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2,4,5,7,8,9,12,14,15,16,45,67,87,88};
        System.out.println(binarySearch(arr,16));
    }

    public static int binarySearch(int[] arr, int val){
        int low =0, high = arr.length-1;
        int mid =  low + (high-low)/2;
        while(low <= high){
            if(arr[mid] == val){
                return mid;
            }else if(arr[mid] > val){
                high = mid-1;
                mid = low + (high-low)/2;
            }else{
                low = mid+1;
                mid = low + (high-low)/2;
            }
        }
        return -1;
    }
    private static int getMid(int low, int high){
        return low + (high-low)/2;
    }

    /*private static int binarySearch(int[] arr, int low, int high, int mid){

    }*/
}
