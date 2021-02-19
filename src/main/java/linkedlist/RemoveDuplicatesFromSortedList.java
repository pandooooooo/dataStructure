package linkedlist;

import dataStructure.ListNode;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/17 11:44 AM
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;

        ListNode prev = head;
        ListNode curr = head.next;

        while(curr != null){
            if(prev.val != curr.val){
                prev = prev.next;
            }else{
                prev.next = curr.next;
            }

            curr = curr.next;
        }

        return head;
    }
}
