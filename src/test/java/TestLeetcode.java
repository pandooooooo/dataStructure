import bfsDfs.WordLadder;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/1/6 10:03 AM
 */
public class TestLeetcode {
    @Test
    public void testLeetcode(){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        WordLadder wordLadder = new WordLadder();
        int x = wordLadder.ladderLength(beginWord, endWord, wordList);

        System.out.println(1);
    }
}
