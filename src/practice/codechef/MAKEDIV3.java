package practice.codechef;

import java.util.Arrays;
import java.util.Scanner;

//https://www.codechef.com/LP2TO301/problems/MAKEDIV3
public class MAKEDIV3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i=0; i<n; i++)
            input[i] = scanner.nextInt();

        for(int num: input)
            System.out.println(getNDigitNumber(num));
    }

    private static String getNDigitNumber(int n){
        if(n==1){
            return "3";
        }
        char[] num = new char[n];
        Arrays.fill(num,'0');
        num[0] = '1';
        num[n-1] = '1';
        if(num[n-2] == '0')
            num[n-2] = '1';
        else
            num[n-2] = '2';
        return new String(num);
    }
}
