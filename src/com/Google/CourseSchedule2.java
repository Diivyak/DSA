package com.Google;

import java.util.ArrayList;

public class CourseSchedule2 {

	public static boolean isCyclic;
	public static ArrayList<Integer> outputOrder;
	public static void dfs(ArrayList<ArrayList<Integer>> scheduleList, int[] buckets, int v , ArrayList<Integer> outputOrder) {
		buckets[v] = 1;
		
		for(Integer u: scheduleList.get(v)) {
			if(buckets[u] == 1) {
				isCyclic = true;
				return;
			}
			if(buckets[u] == 0) {
//				outputOrder.add(u);
				dfs(scheduleList, buckets, u,outputOrder);
				
			}
		}
		if(!outputOrder.contains(v)) outputOrder.add(v);
		buckets[v] =2;
	}
	public static int[] findOrder(int numCourse, int[][] prerequisties) {
		int n = prerequisties.length;
		outputOrder = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> scheduleList = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<= numCourse;i++) scheduleList .add(new ArrayList<Integer>());

		for(int i=0; i<n;i++) scheduleList.get(prerequisties[i][0]).add(prerequisties[i][1]);

		int[] buckets = new int[numCourse];
			
		for(int i=0; i<numCourse; i++) {
			if(buckets[i] == 0) {
//				outputOrder.add(i);
				dfs(scheduleList, buckets, i, outputOrder);
				if(isCyclic) return new int[]{};
			}
		}
		for(int i=0; i<numCourse; i++) {
			buckets[i]= outputOrder.get(i);

		}
		return buckets;

	}

	public static void main(String[] args) {
		int[][] courses = {{0,1},{0,2},{1,2}};
		int numCourse = 3;
		int[] output = findOrder(numCourse, courses);
		for(int c: output) System.out.print(c+" ");

	}

}
