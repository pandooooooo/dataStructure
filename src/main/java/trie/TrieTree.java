package trie;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/28 12:41 PM
 */
public class TrieTree {
    public TrieTree trieTree;
    public char val;
    public TrieTree[] children = new TrieTree[26];
    public boolean isEndingChar = false;

    public TrieTree(char val){
        this.val = val;
    }
}
