package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        //System.out.println(isValidParentheses("())"));
        generateParenthesis(3);
        result.forEach(System.out::println);
    }
    public static void generateParenthesis(int n) {
        createP(n,n,new char[2*n]);
    }

    private static void createP(int s, int e, char[] sequence){
        if(s==0 && e==0 && isValidParentheses(sequence)){
            result.add(new String(sequence));
            //sequence[sequence.length-1]='0';
            return ;
        }
        boolean isValidSequence = isValidParentheses(sequence);
        if(s>0 && isValidSequence){
            sequence[sequence.length - (s+e)] = '(';
            createP(s-1,e,sequence);
            sequence[sequence.length - (s+e)] = 0;
        }
        if(e>0 && isValidSequence){
            sequence[sequence.length - (s+e)] = ')';
            createP(s,e-1,sequence);
            sequence[sequence.length - (s+e)] = 0;
        }
    }

    private static boolean isValidParentheses(char[] sequence){
        int n=0, index=0;
        while(n>=0 && index<sequence.length){
            if(sequence[index]=='(')
                n++;
            else if(sequence[index] == ')')
                n--;
            index++;
        }
        return n>-1;
    }

}
