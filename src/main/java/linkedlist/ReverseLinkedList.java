package linkedlist;

import dataStructure.ListNode;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/1/6 10:23 AM
 */
// [206.反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
