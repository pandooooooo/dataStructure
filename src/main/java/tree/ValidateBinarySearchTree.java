package tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/24 10:48 AM
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        return isValidTraverse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidTraverse(TreeNode node, long minValue, long maxValue) {
        if(node == null)
            return true;

        if(node.val <= minValue || node.val >= maxValue)
            return false;

        return isValidTraverse(node.left, minValue, node.val) && isValidTraverse(node.right, node.val, maxValue);
    }

    public boolean isValidBSTBFS(TreeNode root) {
        if(root == null)
            return true;

        List<Integer> valList = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;

        while(!deque.isEmpty()){
            while(node != null){
                deque.push(node);
                node = node.left;
            }

            node = deque.poll();
            if(node.val >= valList.get(valList.size() - 1)){
                return false;
            }

            valList.add(node.val);

            node = node.right;
        }

        return true;
    }
}
