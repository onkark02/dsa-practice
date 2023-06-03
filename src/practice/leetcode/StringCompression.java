package practice.leetcode;

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int len = compress(chars);
    }

    public static int compress(char[] chars) {
        if(chars.length < 2){
            return chars.length;
        }
        int index=0, compressedIndex=0;
        while(index < chars.length){
            char ch = chars[index];
            int sIndex = index;
            chars[compressedIndex++] = ch;
            while(index < chars.length && chars[index]==ch){
                index++;
            }
            int length = index - sIndex;
            if(length == 1)
                continue;
            if(length > 9){
                String len = "" + length;
                System.out.println(len);
                for(char digit: len.toCharArray()){
                    chars[compressedIndex++] = digit;
                }
            }else{
                chars[compressedIndex++] = (char)(length + '0');
            }
        }
        return compressedIndex;
    }
}
