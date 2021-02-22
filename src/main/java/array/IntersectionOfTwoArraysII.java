package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length)
            return intersectFunction(nums1, nums2);
        else
            return intersectFunction(nums2, nums1);
    }

    private int[] intersectFunction(int[] shortArr, int[] longArr){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int n : shortArr){
            int times = map.getOrDefault(n, 0);
            map.put(n, times+1);
        }

        for(int n : longArr){
            if(map.containsKey(n) && map.get(n)>0){
                list.add(n);
                map.put(n, map.get(n)-1);
            }
        }

        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
