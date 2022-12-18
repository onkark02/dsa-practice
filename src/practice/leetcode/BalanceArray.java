package practice.leetcode;

public class BalanceArray {
    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 4};
        System.out.println(solve(arr));
    }

    public static int solve(int[] A) {
        if(A == null || A.length < 2)
            return 0;

        int[] sumArray = new int[A.length];
        sumArray[0] = A[0];
        sumArray[1] = A[1];
        for(int i=2; i<A.length; i++){
            sumArray[i] = A[i] + sumArray[i-2];
        }
        int count = 0;

        for(int j=0; j<sumArray.length; j++){
            if(isBalanceArrayAfterRemoveIndex(sumArray, j))
                count++;
        }

        return count++;
    }

    private static boolean isBalanceArrayAfterRemoveIndex(int[] sumArray, int indexToRemove){
        int indexDiff = getDiffFromPrev(sumArray, indexToRemove);
        int prevIndexDiff = getDiffFromPrev(sumArray, indexToRemove-1);

        if((sumArray.length-1 - indexToRemove) % 2 == 0){
            return (sumArray[sumArray.length-1] - indexDiff) == (sumArray[sumArray.length-2] - prevIndexDiff);
        }else{
            return (sumArray[sumArray.length-1] - prevIndexDiff) == (sumArray[sumArray.length-2] - indexDiff);
        }
    }

    private static int getDiffFromPrev(int[] sumArray, int index){
        if(index == -1)
            return 0;
        else if(index == 0)
            return sumArray[0];
        else
            return sumArray[index] - sumArray[index-1];
    }

}
