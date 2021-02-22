package string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Integer> sMap = new HashMap<>();

        for(char c: s.toCharArray()){
            if(sMap.containsKey(c)){
                sMap.put(c, sMap.get(c)+1);
            }else{
                sMap.put(c, 1);
            }
        }

        for(char c: t.toCharArray()){
            if(!sMap.containsKey(c) || sMap.get(c)<=0)
                return false;

            sMap.put(c, sMap.get(c)-1);
        }

        return true;
    }
}
