package array;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/20 4:57 PM
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m -n -1;
        int j = n - 1;
        int pos = 0;
        while(i >= 0 && j >= 0){
            int num1 = nums1[i];
            int num2 = nums2[j];
            if(num1 > num2){
                nums1[m-pos-1] = num1;
                i--;
            }else{
                nums1[m-pos-1] = num2;
                j--;
            }
            pos++;
        }
    }
}
