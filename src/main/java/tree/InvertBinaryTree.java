package tree;

import dataStructure.TreeNode;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/27 5:37 PM
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return root;

        invertTraversal(root);

        return root;
    }

    private void invertTraversal(TreeNode node) {
        if(node == null)
            return;

        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;

        invertTraversal(left);
        invertTraversal(right);
    }
}
