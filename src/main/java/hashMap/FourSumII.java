package hashMap;

import java.util.HashMap;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/19 11:47 AM
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> ABMap = new HashMap<>();
        int res = 0;

        for(int a : A){
            for(int b : B){
                ABMap.put(a+b, ABMap.getOrDefault(a+b, 0)+1);
            }
        }

        for(int c : C){
            for(int d : D){
                if(ABMap.containsKey(-c-d)){
                    res += ABMap.get(-c-d);
                }
            }
        }

        return res;
    }
}
