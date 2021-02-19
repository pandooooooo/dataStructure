package hashMap;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/19 11:15 AM
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length())
            return false;

        int[] cMap = new int[26];
        for(char c : s.toCharArray()){
            int pos = c - 'a';
            cMap[pos]++;
        }

        for(char c : t.toCharArray()){
            int pos = c - 'a';
            if(cMap[pos] == 0)
                return false;
            cMap[pos]--;
        }

        return true;
    }
}
