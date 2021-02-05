package dataStructure;

import java.util.List;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/5 5:50 PM
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
