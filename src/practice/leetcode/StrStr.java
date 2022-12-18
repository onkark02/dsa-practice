package practice.leetcode;

public class StrStr {
    public static void main(String[] args) {
        StrStr solution = new StrStr();
        System.out.println(solution.strStr("hello", "hello"));
    }

    public int strStr(String haystack, String needle) {
        if(null == haystack || null == haystack){
            return -1;
        }
        if(needle.length()==0)
            return 0;
        int needleHash = getHash(needle, 0, needle.length()-1);

        for(int i=0; i <=haystack.length()-needle.length(); i++){
            if(needleHash == getHash(haystack, i, i+needle.length()-1) && compare(haystack, i, needle)){
                return i;
            }
        }

        return -1;
    }

    private int getHash(String str, int startIndex, int endIndex){
        int hash = 0;
        for(int i=startIndex; i<=endIndex; i++){
            hash = hash * 31 + str.charAt(i);
        }
        return hash;
    }

    private boolean compare(String haystack, int startIndex, String needle){
        for(int i=0; i<needle.length(); i++){
            if(haystack.charAt(startIndex+i) != needle.charAt(i))
                return false;
        }
        return true;
    }
}
