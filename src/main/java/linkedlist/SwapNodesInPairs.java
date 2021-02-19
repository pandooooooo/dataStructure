package linkedlist;

import dataStructure.ListNode;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/1/6 10:23 AM
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;

        ListNode sentinel = new ListNode(-1);
        ListNode prev = sentinel;
        ListNode former = head;
        ListNode latter = head.next;
        ListNode nextFormer;
        while(former!=null&&latter!=null){
            prev.next = latter;
            nextFormer = latter.next;
            latter.next = former;
            former.next = nextFormer;
            prev = former;
            former = nextFormer;
            latter = former==null?null:former.next;
        }

        return sentinel.next;
    }
}
