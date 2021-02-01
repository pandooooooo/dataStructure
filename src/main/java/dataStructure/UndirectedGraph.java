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
    private boolean found;

    public UndirectedGraph(int v){
        this.v = v;
        adj = new LinkedList[v];
        found = false;
        for(int i=0;i<v;i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s, int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t){
        if(s==t){
            print();
            return;
        }

        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        ((LinkedList<Integer>) queue).add(s);
        int[] prev = new int[v];
        for(int i=0;i<v;i++){
            prev[i] = -1;
        }

        while(!queue.isEmpty()){
            int w = queue.poll();
            for(int i=0;i<adj[w].size();i++){
                int q = adj[w].get(i);
                if(!visited[q]){
                    prev[q] = w;
                    if(q==t){
                        print();
                        return;
                    }
                    visited[q] = true;
                    ((LinkedList<Integer>) queue).add(q);
                }
            }
        }

    }

    public void dfs(int s, int t){
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for(int i=0;i<v;i++){
            prev[i] = -1;
        }

        recDfs(visited, prev, s, t);
    }

    private void recDfs(boolean[] visited, int[] prev, int w, int t) {
        if(found)
            return;

        visited[w] = true;
        if(w==t)
            return;

        for(int i=0;i<adj[w].size();i++){
            int p = adj[w].get(i);
            if(!visited[p]){
                prev[p] = w;
                recDfs(visited, prev, p, t);
            }
        }
    }

    public void print(){
        System.out.println("End.");
    }

}
