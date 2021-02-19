package dataStructure;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/13 8:02 AM
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
    }

    public ListNode(int x, ListNode next){
        val = x;
        this.next = next;
    }
}
