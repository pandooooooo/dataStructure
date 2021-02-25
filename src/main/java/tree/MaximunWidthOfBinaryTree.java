package tree;

import dataStructure.TreeNode;

import java.util.*;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/24 5:10 PM
 */
public class MaximunWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;

        List<Integer> layWidth = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        layWidth.add(1);
        int index = 0;

        while (!queue.isEmpty()){
            int preLen = layWidth.get(index);
            int currLen = 0;
            for(int i=0;i<preLen;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    currLen++;
                    queue.offer(node.left);
                }

                if(node.right != null){
                    currLen++;
                    queue.offer(node.right);
                }
            }

            layWidth.add(currLen);
        }

        return Collections.max(layWidth);
    }

    List<Integer> layerWidthDFS = new ArrayList<>();

    public int widthOfBinaryTreeDFS(TreeNode root){
        if(root == null)
            return 0;

        layerTraverse(root, 0);
        return Collections.max(layerWidthDFS);
    }

    private void layerTraverse(TreeNode node, int layer){
        if(node ==  null)
            return;

        if(layerWidthDFS.size() < layer + 1)
            layerWidthDFS.add(1);
        else
            layerWidthDFS.add(layer, layerWidthDFS.get(layer)+1);

        layerTraverse(node.left, layer+1);
        layerTraverse(node.right, layer+1);
    }
}
