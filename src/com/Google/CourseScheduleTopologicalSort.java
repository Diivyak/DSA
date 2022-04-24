package com.Google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleTopologicalSort {

	public static int[] findOrder(int numCourse, int[][] preReq) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		int n = preReq.length;
		int[] inDeg = new int[numCourse];
		for(int i=0; i<numCourse;i++) list.add(new ArrayList<Integer>());
		
		for(int i=0; i<n;i++) {
			list.get(preReq[i][0]).add(preReq[i][1]);
			inDeg[preReq[i][1]]++;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<numCourse; i++) {
			if(inDeg[i] == 0) q.add(i);
		}
		if(q.isEmpty()) return new int[]{};
		outputOrder = new ArrayList<Integer>();
		int[] buckets = new int[numCourse];
		return getOrder(list, q, buckets, inDeg);

	} 
	public static boolean isCyclic;
	public static ArrayList<Integer> outputOrder;
	public static void dfs(ArrayList<ArrayList<Integer>> scheduleList, int[] buckets, int v,  Queue<Integer> q, int[] inDeg) {
		buckets[v] = 1;
		for(Integer u: scheduleList.get(v)) {
			inDeg[u]--;
			if(inDeg[u] == 0) {
				q.add(u);
			}
			if(buckets[u] == 1) {
				isCyclic = true;
				return;
			}
			if(buckets[u] == 0) dfs(scheduleList, buckets, u, q,inDeg);
		}
		buckets[v] =2;
	}

	public static int[] getOrder(ArrayList<ArrayList<Integer>> scheduleList, Queue<Integer> q, int[] buckets, int[] inDeg) {
		while(!q.isEmpty()) {
			int v = q.poll();
			outputOrder.add(v);
			dfs(scheduleList, buckets, v, q, inDeg);
			if(isCyclic) return new int[]{};
		}

		for(int i=outputOrder.size()-1; i>=0; i--) buckets[i]= outputOrder.get(outputOrder.size()-1-i);
		return buckets;
	}

	public static void main(String[] args) {
//		3
//		[[0,1],[0,2],[1,2]]
		int[][] courses = {{0,1},{0,2},{1,2}};
		int numCourse = 3;
		int[] output = findOrder(numCourse, courses);
		for(int c: output) System.out.print(c+" ");

	}

}
