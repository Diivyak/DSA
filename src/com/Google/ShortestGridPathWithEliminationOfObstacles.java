package com.Google;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestGridPathWithEliminationOfObstacles {

	public static class Pair{
        int i;
        int j;
        int k;
        public Pair(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
        
    }
    public static boolean[][] visited;
    public static int minPathSum;
    public static int[] xDir= {0,1,-1, 0};
    public static int[] yDir= {1,0,0, -1};
    
    public static boolean isValid(int i, int j, int n, int m) {
        if(i >= 0 && i < n && j >= 0 && j < m) return true;
        return false;
    }
    
    public static int bfs(int[][] grid, int i, int j, int k, int n, int m) {
        
//    	int m = grid.length, n = grid[0].length;
//        Queue<int[]> q = new LinkedList<>();
//        int steps = 0;
//        q.offer(new int[]{0,0,k});
//        
//        while(!q.isEmpty()) {
//            int size = q.size();
//            
//            while(size-- > 0) {
//                int[] curr = q.poll();
//                //If curr is the destination; return steps
//                if(curr[0] == m-1 && curr[1] == n-1) return steps;
//                //Else go in all valid directions
//                for(int[] d : DIR) {
//                    int i = curr[0]+d[0];
//                    int j = curr[1]+d[1];
//                    int obs = curr[2];
//                    
//                   //Traverse through the valid cells
//                    if(i >= 0 && i < m && j >= 0 && j < n) {
//                        //If cell is empty visit the cell and add in queue
//                        if(grid[i][j] == 0 && !v[i][j][obs]) {
//                            q.offer(new int[]{i,j,obs});
//                            v[i][j][obs] = true;
//                        }
//                        else if(grid[i][j] == 1 && obs > 0 && !v[i][j][obs-1]) {
//                            q.offer(new int[]{i,j,obs-1});
//                            v[i][j][obs-1] = true;
//                        }
//                    }
//                }
//            }
//            ++steps;
//        }
//        return -1
//    	
//    	
        
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0,0, k));
//        visited[i][j] = true;
        int count=0;
        while(!q.isEmpty()) {
            
            int size = q.size();
            while(size-- > 0) {
                Pair pair = q.poll();
                int k1 = pair.k;
                if(pair.i == n-1 && pair.j == m-1) {
                   return count;
                }
                for(int h=0; h<4;h++) {
                    int i1 = pair.i+ xDir[h];
                    int j1 = pair.j+ yDir[h];
                    if(isValid(i1, j1, n, m)) {
                        if(grid[i1][j1] == 0 && !visited[i1][j1]) {
                             visited[i1][j1] = true;
                            q.add(new Pair(i1, j1, k1));
                        }else if(grid[i1][j1] == 1 &&  pair.k > 0 && !visited[i1][j1]){
                            visited[i1][j1] = true;
                            q.add(new Pair(i1, j1,k1-1));
                        }
                    }
                }
            }
            ++count;
        }
        return -1;
    }
    public static int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        visited = new boolean[n][m];
        return bfs(grid, 0,0,k, n, m);
        
    }
	public static void main(String[] args) {
		int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
		System.out.println(shortestPath(grid, 1));

	}

}
