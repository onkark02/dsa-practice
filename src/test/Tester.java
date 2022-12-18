package test;

import java.io.IOException;
import java.util.Arrays;

public class Tester {
    static String SLASH = "/";
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(isIsomorphic("bar", "foo"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        //Keep mapping of chars from t to s
        int[] charMapping = new int[257];
        Arrays.fill(charMapping,256);
        for(int i=0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(charMapping[tChar] == 256){
                charMapping[tChar] = sChar;
            }else{
                if(charMapping[tChar] != sChar)
                    return false;
            }
        }
        return true;
    }
}
