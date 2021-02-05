package tree;

import dataStructure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/5 5:49 PM
 */

public class NaryTreeLevelOrderTraversal {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if(root==null)
            return res;

        Queue<Node> queue = new LinkedList<>();
        ((LinkedList<Node>) queue).add(root);

        while (!queue.isEmpty()){
            List<Integer> levelRes = new ArrayList<>();
            int nodesNum = queue.size();
            for(int i=0;i<nodesNum;i++){
                Node node = queue.poll();
                for(Node tempNode : node.children){
                    if(tempNode!=null)
                        ((LinkedList<Node>) queue).add(tempNode);

                    levelRes.add(node.val);
                }
            }
        }

        return res;
    }


//    List<List<Integer>> traversalRes = new ArrayList<>();
//
//    public List<List<Integer>> levelOrderDfs(Node root){
//        traversal(root, 0);
//        return traversalRes;
//    }
//
//    private void traversal(Node root, int layer){
//        if(root==null)
//            return;
//
//        if(traversalRes.size()>layer){
//            traversalRes.get(layer).add(root.val);
//        }else{
//            List<Integer> temo = new ArrayList<>();
//            temo.add(root.val);
//            traversalRes.add(temo);
//        }
//
//        for(Node child:root.children){
//            traversal(child, layer+1);
//        }
//    }

    List<List<Integer>> traversalRes = new ArrayList<>();

    public List<List<Integer>> levelOrderDfs(Node root){
        traversal(root, 0);
        return traversalRes;
    }

    private void traversal(Node node, int layer) {
        if(node==null)
            return;

        if(traversalRes.size()>layer){
            traversalRes.get(layer).add(node.val);
        }else{
            List<Integer> layRes = new ArrayList<>();
            layRes.add(node.val);
            traversalRes.add(layRes);
        }

        for(Node tempNode : node.children){
            traversal(tempNode, layer+1);
        }
    }


}
