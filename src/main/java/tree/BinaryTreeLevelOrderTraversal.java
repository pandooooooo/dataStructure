package tree;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/1 3:13 PM
 */

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int levelNodesNum = queue.size();
            for(int i=0;i<levelNodesNum;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null)
                    ((LinkedList<TreeNode>) queue).add(node.left);
                if(node.right!=null)
                    ((LinkedList<TreeNode>) queue).add(node.right);
            }

            res.add(level);
        }

        return res;
    }
}
