package practice.codechef;

import java.util.Scanner;

//https://www.codechef.com/JUNE20B/problems/CHFICRM
public class JUNE20BCHFICRM {
    private static int PRICE = 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        for (int i = 0; i < testCount; i++) {
            int n = sc.nextInt();
            int[] money = new int[n];
            for (int j = 0; j < n; j++) {
                money[j] = sc.nextInt();
            }
            solve(money);
        }
    }
    private static void solve(int[] money){
        int coin5,coin10;
        coin5=coin10 = 0;
        for (int cash: money) {
            switch (cash){
                case 5:
                    coin5++;
                    break;
                case 10:
                    if(coin5 > 0){
                        coin5--;
                        coin10++;
                    }else{
                        System.out.println("NO");
                        return;
                    }
                    break;
                case 15:
                    if(coin10 > 0){
                        coin10--;
                    }
                    else if(coin5 >= 2){
                        coin5-=2;
                    }else {
                        System.out.println("NO");
                        return;
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("YES");
    }
}
