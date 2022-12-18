package practice.classic;

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Node head = createLinkedList(nums);
        printLinkedList(head);
       // head = reverseLinkedList(head);
        head = reverseLinkedListIterative(head);
        printLinkedList(head);


    }

    public static Node reverseLinkedListIterative(Node head) {
        if(head == null)
            return null;
        Node curr = head;
        Node prevNode = null;

        while(curr != null){
            Node next = curr.next;
            curr.next = prevNode;
            if(next == null)
                head = curr;
            prevNode = curr;
            curr = next;
        }

        return head;
    }

    public static Node reverseLinkedList(Node head) {
        if(head == null)
            return null;
        return reverseLinkedList(head,null);
    }

    private static Node reverseLinkedList(Node node, Node prevNode){
        Node next = node.next;
        node.next = prevNode;
        if(next == null){
            return node;
        }else{
            return reverseLinkedList(next,node);
        }
    }

    //Helper function for testing
    private static Node createLinkedList(int[] nums){
        if(nums==null || nums.length == 0)
            return null;
        Node head = new Node(nums[0]);
        Node curr = head;
        for(int i=1; i<nums.length; i++){
            Node node = new Node(nums[i]);
            curr.next = node;
            curr = curr.next;
        }
        return head;
    }

    //Helper function for testing
    private static void printLinkedList(Node head){
        Node curr = head;
        System.out.println("Printing list: ");
        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.print("X\n");
    }

}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}


