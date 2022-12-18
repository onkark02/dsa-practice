package practice.codechef;

import java.util.Scanner;

public class JUNE20BXYSTR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        for (int i = 0; i < testCount; i++) {
            solve(sc.next().toCharArray());
        }
    }

    private static void solve(char[] arr){
        int count =0;
        char lastChar = 'p';
        for (int i = arr.length-1; i >= 0; i--) {
            if((arr[i]=='x' && lastChar=='y') || (arr[i]=='y' && lastChar=='x')){
                lastChar = 'p';
                count++;
            }else {
                lastChar = arr[i];
            }
        }
        System.out.println(count);
    }
}
