package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/1/28 4:11 PM
 */
public class UndirectedGraph {
    private int v;
    private LinkedList<Integer> adj[];

    public UndirectedGraph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s, int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t){
        if(s==t)
            return;

        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] prev = new int[v];
        visited[s] = true;
        queue.add(s);
        for(int i=0;i<v;i++){
            prev[i] = -1;
        }

        while (!queue.isEmpty()){
            int w = queue.poll();
            for(int i=0;i<adj[w].size();i++){
                int q = adj[w].get(i);
                if(!visited[q]){
                    prev[q] = w;
                    if(q==t)
                        return;
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

}
