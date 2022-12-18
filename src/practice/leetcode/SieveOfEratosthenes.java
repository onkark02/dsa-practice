package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {
    private List<Integer> getPrimeNumbers(int n){
        //Create new array, false indicate a prime number & true indicate a non-prime number
        //initially all values are false i.e. prime
        boolean[] nonPrimes = new boolean[n+1];
        nonPrimes[0] = true;
        nonPrimes[1] = true;

        /*
        * For complexity analysis - the inner for loop gets executed n/2 + n/3 + n/5 + ... times
        * Sum of which is O(N * loglogN)
        * */
        for(int i=2; (i*i)<= n; i++){
            if(!nonPrimes[i]){
                for(int j=2; i*j <=n; j++){
                    nonPrimes[i*j] = true;
                }
            }
        }
        return getPrimeNumbers(nonPrimes);
    }

    private List<Integer> getPrimeNumbers(boolean[] nonPrimes) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nonPrimes.length;i++){
            if(!nonPrimes[i]){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        List<Integer> result = sieveOfEratosthenes.getPrimeNumbers(1000);
        System.out.println(result);
    }
}
