package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/19 11:21 AM
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> res = new ArrayList<>();
        if(strs.length==0)
            return res;

        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] temp = new char[26];
            for(char c:str.toCharArray())
                temp[c-'a']++;

            String tempKey = String.valueOf(temp);
            if(!map.containsKey(tempKey))
                map.put(tempKey, new ArrayList<>());
            map.get(tempKey).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
