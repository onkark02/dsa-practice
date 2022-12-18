package practice.random;

//USing recursion
public class StringPalindrome {
    public static void main(String[] args) {
        String str = "sadbsbdas";

        System.out.println(isPalindrome(str,0,str.length()-1));
    }

    private static boolean isPalindrome(String str, int start, int end){
        if(start >= end)
            return true;
        boolean doEndCharsMatch = str.charAt(start) == str.charAt(end);
        return doEndCharsMatch && isPalindrome(str,start+1,end-1);
    }
}
