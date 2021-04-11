package sort;

import org.testng.annotations.Test;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/20 11:49 AM
 */
public class BaseSort {

    public void quickSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int number = nums[start];
        int left = start;
        int right = end;
        while(left <= right){
            while(left <= right && nums[left] < number) {
                left++;
            }
            while(left <= right && nums[right] > number) {
                right--;
            }
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }

    public void quickSortII(int[] nums, int start, int end){
        if(start >= end)
            return;

        int number = nums[start];
        int l = start, r = end;
        while(l <= r){
            while(l <= r && nums[l] < number)   l++;
            while(l <= r && nums[r] > number)   r--;

            if(l <= r){
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r--;
            }
        }

        quickSortII(nums, start, r);
        quickSortII(nums, l, end);
    }

    @Test
    public void test(){
        int[] nums = new int[]{3,2,6,4,7,1,3};
        quickSort(nums, 0, nums.length-1);
        System.out.println(1);
    }
}
