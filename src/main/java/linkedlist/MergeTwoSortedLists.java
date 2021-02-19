package linkedlist;

import dataStructure.ListNode;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/15 10:09 PM
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prevHead = new ListNode(-1);

        ListNode node = prevHead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        node.next = l1==null?l2:l1;

        return prevHead.next;
    }
}
