package practice.leetcode;

public class StringMultiplication {
    public static void main(String[] args) {
        String result = multiply("23","2353");
        System.out.println(result);
    }
    public static String multiply(String num1, String num2) {
        char[] product = new char[num1.length() + num2.length()];

        for(int i=num2.length()-1; i>=0; i--){
            int carry=0;
            int digit2 = num2.charAt(i)-'0';
            for(int j=product.length-1-i,k=num1.length()-1; k>=0; k--,j--){
                int digit1 = num1.charAt(k)-'0';
                int val = digit1*digit2 + product[j] + carry;
                if(val >= 10){
                    carry = val/10;
                    val %= 10;
                }else{
                    carry = 0;
                }
                product[j] = (char) (val+'0');
            }
        }

        return new String(product);
    }
}
