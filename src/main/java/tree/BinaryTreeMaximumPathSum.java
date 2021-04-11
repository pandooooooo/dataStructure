package tree;

import dataStructure.TreeNode;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/24 7:28 PM
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        return maxSum(root);
    }

    private int maxSum(TreeNode node){
        if(node == null)
            return 0;

        int leftGain = Math.max(maxSum(node.left), 0);
        int rightGain = Math.max(maxSum(node.right), 0);

        int newPath = leftGain + node.val + rightGain;

        max = Math.max(newPath, max);

        return node.val + Math.max(leftGain, rightGain);
    }
}
