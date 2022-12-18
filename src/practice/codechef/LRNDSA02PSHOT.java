package practice.codechef;

import java.util.Scanner;

public class LRNDSA02PSHOT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        for(int i = 0; i < testCount; i++) {
            String numStr = sc.next();

            solve(getBooleanArrayFromString(numStr));
        }
    }

    private static void solve(boolean[] scores) {
        int counter =0;
        int firstScore=0, secondScore=0;
        for (; counter < scores.length; counter++) {
            //Score is 1
            if(scores[counter]){
                if(counter % 2==0 ){
                    firstScore++;
                 if(firstScore > secondScore + (scores.length/2 - counter/2))
                     break;
                }else{
                    secondScore++;
                    if (secondScore > firstScore + (scores.length/2 - counter/2))
                        break;
                }

            }else{
                //Score is 0
                if(counter % 2 !=0 ){
                    if(firstScore > secondScore + (scores.length/2 - counter/2))
                        break;
                }else{
                    if (secondScore > firstScore + (scores.length/2 - counter/2))
                        break;
                }
            }
        }
        System.out.println(counter);
    }

    private static boolean[] getBooleanArrayFromString(String str){
        boolean[] arr = new boolean[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) == '1';
        }
        return arr;
    }
}
