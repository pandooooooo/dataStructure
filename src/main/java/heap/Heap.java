package heap;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/3/10 7:16 PM
 */
// 大顶堆
public class Heap {
    int[] a;
    int n;
    int count;


    public Heap(int capacity){
        this.n = capacity;
        a = new int[n + 1];
        count = 0;
    }

    public void insert(int val){
        if(count >= n)
            return;

        Deque<Integer> deque = new LinkedList<>();


        count++;
        a[count] = val;
        int index = count;
        while(index / 2 > 0 && a[index] > a[index/2]){
            swap(a[index], a[index/2]);
            index = index / 2;
        }
    }

    public void removeMax(){
        if(count <= 1)
            return;

        a[1] = a[count];
        count--;
        heapify(1);

    }

    public void buildHeap(int[] a, int n){
        for(int i = n / 2;i >= 1; i--){
            heapify(a, n, i);
        }


        List<Integer> list = new ArrayList<>();


    }

    private void heapify(int[] a, int n, int i) {
        while(true){
            int maxPos = i;
            if(i * 2 <= n && a[i * 2] > a[maxPos])
                maxPos = i * 2;
            if(i * 2 + 1 <=n && a[i * 2 + 1] > a[maxPos])
                maxPos = i * 2 + 1;
            if(maxPos == i)
                break;
            swap(a[i], a[maxPos]);
            i = maxPos;
        }
    }

    private void heapify(int i) {
        while(true){
            int maxPos = i;
            if(i * 2 < n && a[i] < a[i * 2])
                maxPos = i / 2;
            if(i * 2 + 1 < n && a[i * 2 + 1] > a[maxPos])
                maxPos = i * 2 + 1;
            if(maxPos == i)
                break;

            swap(i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int i, int i1) {
    }

}
