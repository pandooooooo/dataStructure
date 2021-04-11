package tree;

import dataStructure.TreeNode;

import java.util.*;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/24 3:29 PM
 */
public class KthSmallestElementInABst {
    List<Integer> nodeVal = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return Integer.parseInt(null);

        inOrder(root);
        return nodeVal.get(k);
    }

    private void inOrder(TreeNode node){
        if(node == null)
            return;

        inOrder(node.left);
        nodeVal.add(node.val);
        inOrder(node.right);
    }

    public int kthSmallestBFS(TreeNode root, int k){
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            while(node != null){
                queue.offer(node.left);
                node = node.left;
            }

            node = queue.poll();
            nodeVal.add(node.val);
            node = node.right;
            queue.offer(node);
        }

        return nodeVal.get(k);
    }
}
