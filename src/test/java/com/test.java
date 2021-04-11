package com;

import dataStructure.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/3/21 3:21 PM
 */
public class test {
    private int lRow;
    private int lCol;
    private int[] dx = new int[]{0, 0, 1, -1, 1, -1, 1, -1};
    private int[] dy = new int[]{1, -1, 0, 0, 1, -1, -1, 1};
    private int partRes = 0;
    public int[] pondSizes(int[][] land) {
        lRow = land.length;
        lCol = land[0].length;

        List<Integer> resList = new ArrayList<>();
        for(int i = 0; i < lRow; i++){
            for(int j = 0; j < lCol; j++){
                partRes = 0;
                dfs(land, i, j);
                if(partRes != 0)
                    resList.add(partRes);
            }
        }

        int[] res = new int[resList.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = resList.get(i);
        }

        Arrays.sort(res);

        return res;
    }

    private void dfs(int[][] land, int x, int y){
        if(x < 0 || x >= lRow || y < 0 || y >= lCol || land[x][y] != 0)
            return;

        partRes++;
        land[x][y] = -1;

        for(int i = 0; i < 8; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            dfs(land, newX, newY);
        }
    }


    @Test
    public void test(){
        // twoSum(new int[]{2, 7, 11, 15}, 9);
        // findKthLargest(new int[]{2, 1}, 2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = null;
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        int[][] arr = new int[][]{{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
        int[] res = pondSizes(arr);


        System.out.println(1);
    }


}
