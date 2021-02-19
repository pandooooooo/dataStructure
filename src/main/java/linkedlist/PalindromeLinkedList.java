package linkedlist;

import dataStructure.ListNode;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/17 10:55 AM
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode slowNext = slow.next;
            slow.next = prev;
            prev = slow;
            slow = slowNext;
        }

        if(fast != null){
            slow = slow.next;
        }

        while(slow != null){
            if(slow.val != prev.val)
                return false;
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }
}
