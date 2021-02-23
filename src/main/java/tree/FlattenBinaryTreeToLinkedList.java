package tree;

import dataStructure.TreeNode;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/23 4:47 PM
 */
public class FlattenBinaryTreeToLinkedList {
    TreeNode preNode;

    public void flatten(TreeNode root) {
        if(root == null)
            return;

        preNode = root;
        preTravers(root);

    }

    private void preTravers(TreeNode node){
        if(node == null){
            return;
        }

        TreeNode tempLeft = node.left;
        TreeNode tempRight = node.right;
        if(preNode != null){
            preNode.right = node;
            preNode.left = null;

            preNode = node;
        }


        preTravers(tempLeft);
        preTravers(tempRight);
    }
}
