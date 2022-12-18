/*
package practice.leetcode;

public class ReverseKGroups {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = createLinkedList(nums);
        printLinkedList(head);
        ReverseKGroups reverseKGroups = new ReverseKGroups();
        head = reverseKGroups.reverseKGroup(head,2);
        printLinkedList(head);
    }



    */
/*
     * Code for reversing K groups
     * *//*

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k<1)
            return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode groupStart;
        while((groupStart = hasKElements(curr,k)) != null){
            ListNode temp = curr;
            curr = reverseList(curr,prev,k);
            if(prev == null)
                head = groupStart;

        }
        prev.next = curr;
        return head;
    }

    private ListNode reverseList(ListNode curr, ListNode prev, int n){
        ListNode next = curr.next;
        curr.next = prev;
        n--;
        if(n==0){
            return next;
        }else{
            return reverseList(next,curr,n);
        }
    }

    private ListNode hasKElements(ListNode head, int k){
        int count=0;
        ListNode node = head;
        while(node != null && count!=k){
            node = node.next;
            count++;
        }
        return node;
    }

    //Helper function for testing
    private static ListNode createLinkedList(int[] nums){
        if(nums==null || nums.length == 0)
            return null;
        ListNode head = new ListNode(nums[0]);
        ListNode curr = head;
        for(int i=1; i<nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            curr.next = node;
            curr = curr.next;
        }
        return head;
    }

    //Helper function for testing
    private static void printLinkedList(ListNode head){
        ListNode curr = head;
        System.out.println("Printing list: ");
        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.print("X\n");
    }
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

*/
