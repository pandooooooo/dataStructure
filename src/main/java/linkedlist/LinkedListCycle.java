package linkedlist;

import dataStructure.ListNode;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/1/6 10:23 AM
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
            return false;

        ListNode fast = head.next;
        ListNode slow = head;

        while(fast!=slow){
            if(fast==null||fast.next==null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
