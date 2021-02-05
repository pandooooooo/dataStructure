import dataStructure.TreeNode;
import org.testng.annotations.Test;
import tree.BinaryTreeLevelOrderTraversal;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/1/6 10:03 AM
 */
public class TestLeetcode {
    @Test
    public void testLeetcode(){
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4, node0, node1);
        TreeNode node5 = new TreeNode(5, node2, node4);
        TreeNode node6 = new TreeNode(6, node3,node5);

        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        binaryTreeLevelOrderTraversal.levelOrder(node6);

        System.out.println(1);
    }
}
