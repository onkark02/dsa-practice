package practice.leetcode;

public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        char c = 'c';
        String str1 = c + "gfd" + 9 + 3;
        System.out.println(str1);
//        String str = "dfsdfsdfwefsgjfhscsdfefsdzfdsfsdfsafsdsfafdfsfsfsdasdasdasdadasdasdasdasdsagadfdassadasdadasdsafdsasdasdad";
//        System.out.println(longestPalindrome.longestPalindrome(str));
    }
    public String longestPalindrome(String s) {
        int maxPalindromeLength = 0;
        String longestPalindrome = null;

        for(int i=0; i<s.length(); i++){
            for(int j=s.length()-1; j>=i; j--){
                int left = i, right = j;
                while(left <= right && s.charAt(left) == s.charAt(right)){
                    left++;
                    right--;
                }
                //Found palindrome
                if(left == right+1 || left == right+2){
                    if(j-i+1 > maxPalindromeLength){
                        longestPalindrome = s.substring(i,j+1);
                        maxPalindromeLength = j-i+1;
                    }
                }

            }
        }

        return longestPalindrome;
    }
}
