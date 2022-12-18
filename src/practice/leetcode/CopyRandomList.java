package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public static void main(String[] args) {
        CopyRandomList solution = new CopyRandomList();
        Node head = createTestList();
        Node newHead = solution.copyRandomList(head);
        System.out.println(newHead);
    }

    private static Node createTestList(){
        Node head = new Node(1);
        Node node = new Node(2);
        head.next = node;
        head.random = node;
        node.random = node;
        return head;
    }

    public Node copyRandomList(Node head) {
        Node curr = head;
        Map<Node, Integer> nodeToIndexMap = new HashMap<>();
        Node dummy = new Node(-1);
        Node temp = dummy;

        int size = fillNodeToIndexMap(nodeToIndexMap, curr);
        Node[] nodes = new Node[size];

        int index=0;
        while(curr != null){
            Node node = new Node(curr.val);
            nodes[index++] = node;
            dummy.next = node;
            dummy = dummy.next;
            curr = curr.next;
        }

        curr = head;
        index = 0;
        while(curr != null){
            if(curr.random != null){
                nodes[index].random = nodes[nodeToIndexMap.get(curr.random)];
            }
            curr = curr.next;
            index++;
        }

        return temp.next;
    }

    private int fillNodeToIndexMap(Map<Node, Integer> nodeToIndexMap, Node head){
        Node curr = head;
        int index=0;
        while(curr != null){
            nodeToIndexMap.put(curr, index++);
            curr = curr.next;
        }
        return index;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
