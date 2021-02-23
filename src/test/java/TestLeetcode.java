import dataStructure.TreeNode;
import org.testng.annotations.Test;
import tree.FlattenBinaryTreeToLinkedList;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/1/6 10:03 AM
 */
public class TestLeetcode {
    @Test
    public void testLeetcode(){
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, node4);
        TreeNode node1 = new TreeNode(1, node2, node5);

        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        flattenBinaryTreeToLinkedList.flatten(node1);
    }
}
