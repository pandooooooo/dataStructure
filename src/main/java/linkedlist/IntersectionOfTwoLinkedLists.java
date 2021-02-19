package linkedlist;

import dataStructure.ListNode;

import java.util.HashSet;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/17 9:59 AM
 */
public class IntersectionOfTwoLinkedLists {
    // 若相交，链表A： a+c, 链表B : b+c. a+c+b+c = b+c+a+c 。则会在公共处c起点相遇
    // 若不相交，a +b = b+a
    // 因此相遇处是NULL
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while(nodeA != nodeB){
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }

    public ListNode getIntersectionNodeHash(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodeSet = new HashSet<>();

        ListNode node = headA;
        while(node != null){
            nodeSet.add(node);
            node = node.next;
        }

        node = headB;
        while(node != null){
            if(nodeSet.contains(node))
                return node;

            node = node.next;
        }

        return null;
    }
}
