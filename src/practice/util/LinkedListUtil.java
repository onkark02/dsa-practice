package practice.util;

public class LinkedListUtil {
    //Helper function for testing
    public static ListNode createLinkedList(int[] nums){
        if(nums==null || nums.length == 0)
            return null;
        ListNode head = new ListNode(nums[0]);
        ListNode curr = head;
        for(int i=1; i<nums.length; i++){
            ListNode ListNode = new ListNode(nums[i]);
            curr.next = ListNode;
            curr = curr.next;
        }
        return head;
    }

    //Helper function for testing
    public static void printLinkedList(ListNode head){
        ListNode curr = head;
        System.out.println("Printing list: ");
        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.print("X\n");
    }
}
