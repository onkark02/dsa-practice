package practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CheckIfDoubleExists {
    public static void main(String[] args) {
        int[] arr = {2,5,61,7,114};
        System.out.println(checkIfExist(arr));
    }
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i < arr.length; i++){
            if(set.contains(2*arr[i]) || (arr[i] %2 ==0 && set.contains(arr[i]/2)))
                return true;
            set.add(arr[i]);
        }
        return false;
    }

}


