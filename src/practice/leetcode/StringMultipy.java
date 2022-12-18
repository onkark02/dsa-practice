package practice.leetcode;

import java.util.Arrays;

public class StringMultipy {
    public static void main(String[] args) {
        StringMultipy stringMultipy = new StringMultipy();
        System.out.println(stringMultipy.multiply("0","456"));
    }

    public String multiply(String num1, String num2) {
        if(num1 == "0" || num2 == "0"){
            return "0";
        }
        int carry=0;
        char[] result = new char[num1.length() + num2.length()];
        Arrays.fill(result, '0');

        for(int i=num1.length()-1; i >=0 ; i--){
            int multiplier = num1.charAt(i) - '0';
            for(int j=num2.length()-1; j>=0; j--){
                int digit = num2.charAt(j) - '0';
                int index = i+j+1;
                int sum = multiplier*digit + carry + result[index] - '0';
                carry = sum/10;
                result[index] = (char) (sum%10+'0');
            }
            if(carry > 0){
                result[i] = (char) (carry+'0');
                carry = 0;
            }
        }
        String answer = new String(result);
        return result[0]=='0' ? answer.substring(1):answer;
    }

}
