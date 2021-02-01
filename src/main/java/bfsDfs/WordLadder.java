package bfsDfs;

//127	https://leetcode-cn.com/problems/word-ladder/description/
//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
// 序列中第一个单词是 beginWord 。
// 序列中最后一个单词是 endWord 。
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典 wordList 中的单词。
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。
// 示例 1：
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
//
// 示例 2：
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。
//
// 提示：
// 1 <= beginWord.length <= 10
// endWord.length == beginWord.length
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// beginWord、endWord 和 wordList[i] 由小写英文字母组成
// beginWord != endWord
// wordList 中的所有字符串 互不相同
//

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/1 3:28 PM
 */
public class WordLadder {
    private int v;
    private HashMap<String, LinkedList<String>> adj;
    private int ladder;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        v = wordList.size()+1;
        adj = new HashMap<String, LinkedList<String>>();
        for(int i=0;i<wordList.size();i++){
            String tempWord = wordList.get(i);
            adj.put(tempWord, new LinkedList<String>());
        }

        if(!adj.containsKey(endWord))
            return 0;

        adj.put(beginWord, new LinkedList<String>());
        wordList.add(beginWord);


        addEdge(wordList, endWord);

        bfs(beginWord, endWord);

        return 0;
    }

    private void bfs(String beginWord, String endWord) {
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);
        HashMap<String, String> prev = new HashMap<String, String>();
        Queue<String> queue = new LinkedList<String>();
        ((LinkedList<String>) queue).add(beginWord);

        while(!queue.isEmpty()){
            String w = queue.poll();
            for(int i=0;i<adj.get(w).size();i++){
                String q = adj.get(w).get(i);
                if(!visited.get(q)){
                    prev.put(q, w);
                    if(compareWord(q, endWord)){
                        System.out.println(endWord);
                        return;
                    }
                    visited.put(q, true);
                    ((LinkedList<String>) queue).add(q);
                }
            }
        }


    }

    private void addEdge(List<String> wordList, String endWord) {

        for(int i=0;i<v;i++){
            String word = wordList.get(i);
            for(int j=i+1;j<v;j++){
                String tempWord = wordList.get(j);
                if(compareWord(word, tempWord)){
                    adj.get(word).add(tempWord);
                    adj.get(tempWord).add(word);
                }
            }
        }
    }

    private boolean compareWord(String word, String tempWord) {
        int count = 0;
        for(int i=0;i<word.length();i++){
            if(word.toCharArray()[i]!=tempWord.toCharArray()[i])
                count++;
            if(count>1)
                return false;
        }

        return true;
    }
}
