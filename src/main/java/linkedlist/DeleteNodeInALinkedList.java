package linkedlist;

import dataStructure.ListNode;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/13 9:20 AM
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while(curr != node){
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
    }
}
