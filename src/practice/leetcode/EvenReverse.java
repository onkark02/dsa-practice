package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://www.interviewbit.com/problems/even-reverse/
public class EvenReverse {

    public ListNode solve(ListNode A) {
        List<ListNode> odd = new ArrayList<>();
        List<ListNode> even = new ArrayList<>();
        ListNode curr = A;
        int k=1;
        while(curr != null){
            if(k % 2 == 0)
                even.add(curr);
            else
                odd.add(curr);
            k++;
            curr = curr.next;
        }
        ListNode result = new ListNode(-1);
        ListNode ptr = result;
        for(int i=0,j=0; i<odd.size(); i++,j++){
            ptr.next = odd.get(i);
            ptr = ptr.next;

            if(j < even.size()){
                ptr.next = even.get(even.size()-1-j);
                ptr = ptr.next;
            }
        }
        ptr.next = null;
        return result.next;
    }
    /*
    1 -> 2 -> 3 -> 4 -> 5
    1 -> 4 -> 3 -> 2 -> 5

    1 -> 3 -> 5
    2 -> 4
    4 -> 2
    1 -> 4 -> 3 -> 2 -> 5
    */
    public ListNode solve1(ListNode A) {
        if(A == null){
            return null;
        }
        ListNode even= new ListNode(-1), evenPtr;
        ListNode odd= new ListNode(-1), oddPtr;
        ListNode curr = A;

        while(curr != null){
            oddPtr = curr;
            oddPtr = oddPtr.next;
            if(odd == null){
                odd = curr;
            }
            curr = curr.next;
            if(curr != null){
                evenPtr = curr;
                evenPtr = evenPtr.next;
                if(even == null){
                    even = curr;
                }
                curr = curr.next;
            }
        }

        ListNode reversedEven = reverseList(even);

        ListNode result=null, resultPtr;
        oddPtr = odd;
        evenPtr = reversedEven;
        while(oddPtr != null){
            resultPtr = oddPtr;
            resultPtr = resultPtr.next;
            if(result == null){
                result = oddPtr;
            }
            oddPtr = oddPtr.next;

            if(evenPtr != null){
                resultPtr = evenPtr;
                evenPtr = evenPtr.next;
                resultPtr = resultPtr.next;
            }
        }

        return result;
    }

    /*
     3 -> 5
    */
    private ListNode reverseList(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class  ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
    }

    public static void main(String[] args) {
        EvenReverse evenReverse = new EvenReverse();
        ListNode listNode = getLL();
        ListNode result = evenReverse.solve(listNode);
        System.out.println("---");
    }

    private static ListNode getLL(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        //l4.next = l5;
        return l1;
    }
}
