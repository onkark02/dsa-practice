package practice.leetcode;

//https://leetcode.com/problems/reorder-list/
public class RearrangeLinkedList {
    public static void main(String[] args) {
        int[] arr = {};
        RearrangeLinkedList solution = new RearrangeLinkedList();
        ListNode list = solution.createLinkedList(arr);
        printLinkedList(list);
        solution.reorderList(list);
        printLinkedList(list);
    }

    private static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private ListNode createLinkedList(int[] nums){
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

    public void reorderList(ListNode head) {
        if(head != null){
            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next != null){
                fast = fast.next.next;
                if(fast != null)
                    slow = slow.next;
            }

            ListNode second = slow.next;
            slow.next = null;

            second = reverseList(second);

            head =  mergeLists(head, second);
        }
    }

    private ListNode mergeLists(ListNode n1, ListNode n2){
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while(n1 != null && n2 != null){
            dummy.next = n1;
            n1 = n1.next;
            dummy = dummy.next;
            dummy.next = n2;
            n2 = n2.next;
            dummy = dummy.next;
        }

        while(n1 != null){
            dummy.next = n1;
            n1 = n1.next;
            dummy = dummy.next;
        }
        //dummy = null;

        return head.next;
    }

    private ListNode reverseList(ListNode head){
        if(head == null)
            return null;

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
