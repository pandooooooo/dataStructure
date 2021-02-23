package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/23 11:22 AM
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i=0; i< nums.length;i++)
        {
            sum += i;
            sum -= nums[i];
        }

        return sum;
    }

    public int missingNumberBitwise(int[] nums){
        int missing = 0;

        for(int i=0;i<nums.length;i++){
            missing = i ^ nums[i];
        }

        return missing;
    }

    public int missingNumberHashMap(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        for(int i=0;i<nums.length;i++){
            if(!set.contains(i))
                return i;
        }

        return -1;
    }
}
