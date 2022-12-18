package practice.leetcode;

//https://www.interviewbit.com/problems/next-similar-number/
public class NextSimilarNumber {
    public static void main(String[] args) {
/*        String str = "5555555555555555555555555555555546";
*//*        char[] arr = str.toCharArray();
        swapElementsAndReverseNext(arr,2,'4');*//*
        System.out.println(solve(str));*/

        int num = 234231;
        System.out.println(getStringFromNumber(num));
    }

    private static String getStringFromNumber(int A){
        StringBuilder sb = new StringBuilder();

        while(A/10 != 0){
            int digit = A%10;
            char ch = (char) (digit+48);
            sb.append(ch);
            A /= 10;
        }
        char ch = (char) (A+48);
        sb.append(ch);

        return sb.toString();
    }

    public static String solve(String A) {
        char charAtEnd = A.charAt(A.length()-1);
        int index;
        for(index = A.length()-2; index >=0; index--){
            char ch = A.charAt(index);
            if(ch < charAtEnd)
                break;
            charAtEnd = ch;
        }
        if(index == -1){
            return "-1";
        }else{
           int nextDigitIndex = A.length()-1;
           for(;nextDigitIndex>index; nextDigitIndex--){
               if(A.charAt(index) < A.charAt(nextDigitIndex))
                   break;
           }
           char[] arr = A.toCharArray();
           char temp = arr[index];
           arr[index] = arr[nextDigitIndex];
           arr[nextDigitIndex] = temp;
            StringBuilder sb = new StringBuilder();

           int l = index + 1, r = arr.length-1;
           while(l < r){
               char tmp = arr[l];
               arr[l] = arr[r];
               arr[r] = tmp;
               l++;
               r--;
           }
           return new String(arr);
        }
    }

}
