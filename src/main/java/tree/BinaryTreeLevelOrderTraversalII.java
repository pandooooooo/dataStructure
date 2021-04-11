package tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/27 5:29 PM
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> layerRes = new ArrayList<>();
            for(int i = 0;i< size;i++){
                TreeNode node = queue.poll();
                layerRes.add(node.val);

                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }

            res.add(0, layerRes);
        }

        return res;
    }
}
