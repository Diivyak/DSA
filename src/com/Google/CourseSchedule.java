package com.Google;

import java.util.ArrayList;

public class CourseSchedule {

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> dependencyList = new ArrayList<ArrayList<Integer>>();
        isCyclic = false;
        int n = prerequisites.length;
        
        for(int i=0; i<=n;i++) dependencyList.add(new ArrayList<Integer>());
        
        for(int i= 0; i<n;i++) {
            dependencyList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int[] bucket = new int[numCourses];
        for(int i=0; i<numCourses;i++) {
            if(bucket[i] == 0){
                dfs(dependencyList , bucket, i);
                if(isCyclic) {
                    return false;
                }
            }
        }
       return true;
    }

    public static boolean isCyclic;
    public static void dfs(ArrayList<ArrayList<Integer>> dependencyList, int[] bucket, int i) {
        bucket[i] = 1;
        for(Integer course:  dependencyList.get(i)) {
            if(bucket[course] == 1) {
                isCyclic = true;
                return;
            }
            if(bucket[course] == 0) {
                dfs(dependencyList, bucket, course);
            }
        }
        bucket[i] = 2;
    }
    
	public static void main(String[] args) {
//		[[1,0],[2,0],[3,1],[3,2]]
//		numCourses = 2, prerequisites = [[1,0]]
		int[][] courses = {{1,0},{2,0},{3,1},{3,2}};
		int numCourse = 4;
		System.out.println(canFinish(numCourse, courses));

	}

}
