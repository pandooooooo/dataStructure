package linkedlist;

import dataStructure.ListNode;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/1/6 10:23 AM
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)
            return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow!=fast){
            if(fast==null||fast.next==null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode circleNode = slow;
        while(head!=circleNode){
            head = head.next;
            circleNode = circleNode.next;
        }

        return head;
    }
}
