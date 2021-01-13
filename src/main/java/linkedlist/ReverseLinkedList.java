package linkedlist;

import dataStructure.ListNode;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/1/6 10:23 AM
 */
public class ReverseLinkedList {
    public ListNode solution(ListNode head){
        if(head==null || head.next==null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}
