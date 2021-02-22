package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/20 4:27 PM
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length)
            return interSectionFunction(nums1, nums2);
        else
            return interSectionFunction(nums2, nums1);
    }

    private int[] interSectionFunction(int[] shortArr, int[] longArr){
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for(int n : shortArr){
            set.add(n);
        }

        for(int n : longArr){
            if(set.contains(n)){
                list.add(n);
                set.remove(n);
            }
        }

        int[] res = new int[list.size()];
        for(int i=0; i<list.size();i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
