package dataStructure;

import trie.TrieTree;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/28 12:40 PM
 */
public class Trie {
    public TrieTree root = new TrieTree('/');

    public void insert(char[] text){
        TrieTree p = root;
        for(int i=0;i<text.length;i++){
            int index = text[i] - 'a';
            if(p.children[i] == null){
                p.children[i] = new TrieTree(text[i]);
            }

            p = p.children[i];
        }

        p.isEndingChar = true;
    }

    public boolean find(char[] pattern){
        TrieTree p = root;

        for(int i=0;i<pattern.length;i++){
            int index = pattern[i] - 'a';
            if(p.children[index] == null)
                return false;
            else
                p = p.children[index];
        }

        return p.isEndingChar;
    }
}
