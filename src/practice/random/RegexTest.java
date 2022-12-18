package practice.random;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {

        String string = "[a-zA-Z]*.csv";
        Pattern pattern = Pattern.compile(string);
        Matcher matcher = pattern.matcher("test.csv");
        System.out.println(matcher.matches());
    }
}
