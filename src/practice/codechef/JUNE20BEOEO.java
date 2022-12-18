package practice.codechef;

import java.util.Scanner;

public class JUNE20BEOEO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        for (int i = 0; i < testCount; i++) {
            long n = sc.nextLong();
            solve(n);
        }
    }
    private static void solve(long n){
        if(n%2==1){
            long values = (n-1)/2;
            System.out.println(values);
        }else{
/*            long tempN;
            long values =0;
            for (long i = 2; i < n; i+=2) {
                long tempI = i;
                tempN =n;
                while(tempI%2==0 && tempN%2==0){
                    tempN /= 2;
                    tempI /=2;
                }
                if(tempI%2==0){
                    System.out.println("Value: "+i);
                    values++;
                }
            }*/
            while(n%2 == 0 && n>0){
                n = n >> 1;
            }
            n = n >> 1;
            System.out.println(n);
        }
    }
}
