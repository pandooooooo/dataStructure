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

        Deque<WidthNode> queue = new LinkedList<>();
        queue.offer(new WidthNode(root, 0, 1));
        int Depth = 0, res = 0, left = 0;
        while(!queue.isEmpty()){
            WidthNode curr = queue.poll();
            if(curr != null){
                queue.offer(new WidthNode(curr.node.left, curr.depth + 1, curr.position * 2));
                queue.offer(new WidthNode(curr.node.right, curr.depth + 1, curr.position * 2 + 1));

                if(Depth != curr.depth){
                    Depth = curr.depth;
                    left = curr.position;
                }
            }
            res = Math.max(res, curr.position - left + 1);
        }

        return res;
    }

    class WidthNode{
        TreeNode node;
        int depth;
        int position;

        public WidthNode(TreeNode node, int depth, int position){
            this.node = node;
            this.depth = depth;
            this.position = position;
        }
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
