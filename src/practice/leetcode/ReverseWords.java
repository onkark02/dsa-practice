package practice.leetcode;

public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String str = "onewordtest";
        
        System.out.println(reverseWords.reverseWords(str));
    }

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int wordStartPtr = 0;
        while (wordStartPtr < arr.length) {
            int spacePtr = wordStartPtr + 1;
            while (spacePtr < arr.length && arr[spacePtr] != ' ')
                spacePtr++;
            if (spacePtr == arr.length)
                break;

            reverse(arr, wordStartPtr, spacePtr - 1);
            wordStartPtr = spacePtr + 1;

        }
        reverse(arr, wordStartPtr, arr.length - 1);
        return new String(arr);
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
