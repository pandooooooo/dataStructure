package sort;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/20 11:49 AM
 */
public class BaseSort {
    public void bubbleSort(int[] arr, int n){
        if(n<=1)
            return;

        boolean flag = true;

        for(int i=arr.length-1; i>0;i--){
            for(int j=i;j>=0;j--){

            }
        }
    }

    public void insertSort(int[] arr, int n){
        if(n <= 1)
            return;

        for(int i=1; i<arr.length; i++){
            for(int j=i; j>0; j--){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }

        System.out.println(1);
    }
}
