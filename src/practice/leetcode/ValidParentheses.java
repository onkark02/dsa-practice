package practice.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.longestValidParentheses("(()))()()()()()"));
    }

    public int longestValidParentheses(String s) {
        int maxLength=0;
        Deque<Parenthesis> parentheses = new LinkedList<>();

        for(int i=0; i<s.length(); i++){

        }

        return maxLength;
    }

    class Parenthesis{
        int index;
        boolean isClosed;

        public Parenthesis(int index){
            this.index = index;
            isClosed = false;
        }

        public void setClosed(){
            isClosed = true;
        }
    }
}
