package practice.leetcode;

import practice.util.LinkedListUtil;
import practice.util.ListNode;

public class RemoveDuplicateNodes {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,4,5,6,7};
        practice.util.ListNode listNode = LinkedListUtil.createLinkedList(nums);
        ListNode node = deleteDuplicates(listNode);
        LinkedListUtil.printLinkedList(node);
    }
    public static ListNode deleteDuplicates(practice.util.ListNode head) {
        // sentinel
        ListNode sentinel = new ListNode(0, head);

        // predecessor = the last node
        // before the sublist of duplicates
        ListNode pred = sentinel;

        while (head != null) {
            // if it's a beginning of duplicates sublist
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // skip all duplicates
                pred.next = head.next;
                // otherwise, move predecessor
            } else {
                pred = pred.next;
            }

            // move forward
            head = head.next;
        }
        return sentinel.next;
    }
}
