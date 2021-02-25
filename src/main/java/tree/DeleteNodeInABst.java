package tree;

import dataStructure.TreeNode;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/24 2:26 PM
 */
public class DeleteNodeInABst {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(key > root.val)
            deleteNode(root.right, key);
        else if(key < root.val)
            deleteNode(root.left, key);
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                TreeNode node = root.right;
                while(node.left != null)
                    node = node.left;

                node.left = root.left;
                return root.right;
            }
        }

        return root;
    }
}
