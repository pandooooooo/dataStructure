package tree;

import dataStructure.TreeNode;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/24 3:50 PM
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    TreeNode head;
    TreeNode pre;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null)
            return root;

        inOrder(root);

        head.left = pre;
        pre.right = head;

        return head;
    }

    private void inOrder(TreeNode curr){
        if(curr == null)
            return;

        inOrder(curr.left);
        if(pre != null)
            pre.left = curr;
        else
            head = curr;

        curr.right = pre;
        pre = curr;


        inOrder(curr.right);
    }
}
