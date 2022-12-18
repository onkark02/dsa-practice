package practice.leetcode;

public class BinarySum {
    public static void main(String[] args) {
        String output = addBinary("110", "10101");
        System.out.println(output);
    }
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i1 = a.length()-1, i2 = b.length()-1;
        while(i1 >=0 && i2 >= 0){
            int sum = Character.getNumericValue(a.charAt(i1)) + Character.getNumericValue(b.charAt(i2)) + carry;
            if(sum > 1){
                carry = 1;
                sum -= 2;
            }else{
                carry = 0;
            }
            sb.append(sum);
            i1--;
            i2--;
        }
        while(i1 >= 0){
            int sum =  Character.getNumericValue(a.charAt(i1)) + carry;
            if(sum > 1){
                carry = 1;
                sum=0;
            }else {
                carry = 0;
            }
            sb.append(sum);
            i1--;
        }
        while(i2 >= 0){
            int sum =  Character.getNumericValue(b.charAt(i2)) + carry;
            if(sum > 1){
                carry = 1;
                sum=0;
            }else {
                carry = 0;
            }
            sb.append(sum);
            i2--;
        }
        if(carry > 0){
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }
}
