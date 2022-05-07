package com.arrays.easy;

import java.util.ArrayList;

public class IsGraphBipartite {

	public static boolean isBipartiteGraph;
    public static ArrayList<ArrayList<Integer>> list;
    public static int[] cols;
    public static boolean[] visited;
    
    public static void dfs(int u, int c) {
        visited[u] = true;
        cols[u] = c;
        for(int v: list.get(u)) {
            if(!visited[v]) {
                dfs(v, 1-c);
            }
            else if(visited[v] && cols[v] == c){
                isBipartiteGraph = false;
                return;
            }
        }
        
    }
    public static boolean isBipartite(int[][] graph) {
        list = new ArrayList<ArrayList<Integer>>();
        int n = graph.length;
        visited = new boolean[n];
        cols= new int[n];
        for(int i=0; i<n;i++) {
            list.add(new ArrayList<Integer>());
        }
        for(int i=0; i<n;i++) {
            int len = graph[i].length;
            for(int j=0; j<len;j++) {
                list.get(i).add(graph[i][j]);
            }
        }
        isBipartiteGraph = true;
        for(int i=0; i<n;i++) {	
            if(!visited[i]) {
                if(isBipartiteGraph) {
                    dfs(i, 0);
                }else{
                    return isBipartiteGraph;
                }
            }
        }
        return isBipartiteGraph;
        
    }
	public static void main(String[] args) {
//		int[][] arr = {{1,2,3},{0,2},{0,1,3},{0,2}};
		int[][] arr = {{1,3},{0,2},{1,3},{0,2}};
		System.out.println(isBipartite(arr));

	}

}
