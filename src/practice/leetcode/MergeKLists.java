/*
package practice.leetcode;

public class MergeKLists {
    static ListNode list = null, curr = null;
    public static ListNode mergeKLists(ListNode[] lists) {
        boolean listEmpty = false;

        while(!listEmpty){
            ListNode tempNode = null;
            int minIndex = -1;
            listEmpty = true;
            for(int i=0; i < lists.length; i++){
                if(lists[i] != null){
                    listEmpty = false;
                    if(tempNode==null || lists[i].val < tempNode.val){
                        tempNode = lists[i];
                        minIndex = i;
                    }
                }
            }
            if(minIndex != -1){
                if(curr == null){
                    curr = tempNode;
                    list = curr;
                }else{
                    curr.next = tempNode;
                    curr = curr.next;
                }
                lists[minIndex] = lists[minIndex].next;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        int[] list1 = {2,4,6};
        int[] list2 = {3,4};
        int[] list3 = {1,4,7,8,9};
        listNodes[0] = createList(list1);
        listNodes[1] = createList(list2);
        listNodes[2] = createList(list3);
        ListNode mergedNode = mergeKLists(listNodes);
        while (mergedNode != null){
            System.out.println(mergedNode.val);
            mergedNode = mergedNode.next;
        }
    }

    private static ListNode createList(int[] values){
        ListNode listNode = null, curr= null;
        for(int value: values){
            ListNode newNode = new ListNode(value);
            if(curr == null){
                curr = listNode = newNode;
            }else{
                curr.next = newNode;
                curr = curr.next;
            }
        }
        return listNode;
    }
}



class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
*/
