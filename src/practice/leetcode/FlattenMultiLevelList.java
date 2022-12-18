package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FlattenMultiLevelList {
    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public static void main(String[] args) {
        String[] arr = {String.valueOf(1), String.valueOf(2), String.valueOf(3), String.valueOf(4), String.valueOf(5), String.valueOf(6),null,null,null, String.valueOf(7), String.valueOf(8), String.valueOf(9), String.valueOf(10),null,null, String.valueOf(11), String.valueOf(12)};
        FlattenMultiLevelList solution = new FlattenMultiLevelList();
        List<String> list = new ArrayList<>();
        Node head = solution.createMultiLevelList(arr);
    }

    private  Node createMultiLevelList(String[] arr) {
        Node head = null, headPtr = null;
        boolean levelReversal = false, addChildNode = false;
        for(String val: arr){
            if(val != null){
                Node newNode = new Node();
                newNode.val = Integer.parseInt(val);
                if(headPtr == null){
                    newNode.prev =
                    head = newNode;
                    headPtr = head;
                }else{
                    headPtr.next = newNode;
                    headPtr = headPtr.next;
                }
            }else{
                if(!levelReversal){
                    while(headPtr.prev != null)
                        headPtr = headPtr.prev;
                    levelReversal = true;
                }else{
                    levelReversal = false;
                    addChildNode = true;
                    headPtr = headPtr.next;
                }
            }
        }
        return head;
    }


}
