package practice.dp;

public class Fibonacci {
    public static void main(String[] args) {
//        System.out.println(fibRecursive(6));
//        System.out.println(fibRecursive(7));
//        System.out.println(fibRecursive(8));
//        System.out.println(fibRecursive(50));
    }

    //This recursive implementation is correct but is very slow for larger numbers, hence an inefficient solution
    static long fibRecursive(long n){
        if(n== 0 || n==1){
            return 1;
        }else{
            return fibRecursive(n-1) + fibRecursive(n-2);
        }
    }

    static long fib(long n){
        if(n== 0 || n==1){
            return 1;
        }else{
            return fibRecursive(n-1) + fibRecursive(n-2);
        }
    }
}
