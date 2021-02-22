package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if(s.length() == 1)
            return 0;

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c))
                map.put(c, i);
            else
                map.put(c, -1);
        }

        int res = s.length();
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            int pos = entry.getValue();
            if(pos != -1 && pos < res){
                res = pos;
            }
        }

        if(res == s.length())
            return -1;

        return res;
    }

    public int firstUniqCharQueue(String s){
        if(s.length() == 1)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<Pair>();
        int n = s.length();

        for(int i = 0;i < n;i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, i);
                queue.offer(new Pair(c, i));
            }else{
                map.put(c, -1);
                while(!queue.isEmpty() && map.get(queue.peek().c) == -1){
                    queue.poll();
                }
            }
        }

        return queue.isEmpty() ? -1 : queue.peek().pos;
    }

    class Pair{
        char c;
        int pos;

        Pair(char c, int pos){
            this.c = c;
            this.pos = pos;
        }
    }
}
