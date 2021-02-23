package tree;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/23 3:32 PM
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left==null && root.right==null))
            return true;

        return sysmmetricTraverse(root.left, root.right);
    }

    private boolean sysmmetricTraverse(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;

        if(left == null || right == null)
            return false;

        return left.val == right.val && sysmmetricTraverse(left.left, right.right) && sysmmetricTraverse(left.right, right.left);
    }

    public boolean isSymmetricBFS(TreeNode root){
        if(root == null || (root.left==null && root.right==null))
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root.left);
        ((LinkedList<TreeNode>) queue).add(root.right);

        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null)
                continue;

            if(left == null || right == null)
                return false;

            if(left.val != right.val)
                return false;

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(left.left);
        }

        return true;
    }
}
