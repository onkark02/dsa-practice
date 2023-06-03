package practice.random;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;

public class TimeTester {
    private static final Pattern invalidPattern = Pattern.compile(".*//.*");
    
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        String path = "//                     sting/path/aodak/file.txt  /";
        path.contains("");
        if(invalidPattern.matcher(path).matches()){
            System.out.println("Invalid path");
        }else
            System.out.println("valid path");
    }


}
