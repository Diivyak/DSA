package com.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnapShotArray {

	public static class Test {
		public static List<HashMap<Integer, Integer>> list;
		public static int snapId;
		
	    public Test(int length) {
	        snapId = 0;
	        list = new ArrayList<HashMap<Integer, Integer>>();
	        for(int i=0; i<length;i++) {
	       	 list.add(new HashMap<Integer, Integer>());
	       	 list.get(i).put(snapId, 0);
	       }
	       
	    }
		    
	    public void set(int index, int val) {
	        list.get(index).put(snapId, val);
	        return ;
	    }

	    public int snap() {
	        return snapId++;
	    }

	    public int get(int index, int snap_id) {
//	        if(list.get(index).containsKey(snap_id)) {
//	            return list.get(index).get(snap_id);
//	        }
	        while(snap_id >= 0 && !list.get(index).containsKey(snap_id)) {
	        	snap_id--;
	        }
	        return list.get(index).get(snap_id);
	    }
	}
	
	    
	public static void main(String[] args) {
		
//		["SnapshotArray","snap","snap","get","set","snap","set"]
//				[[4],[],[],[3,1],[2,4],[],[1,4]]
						
//		String[] str = {"SnapshotArray","set","snap","set","get"};
//		int[][] input= {{3},{0,5},{},{0,6},{0,0}};
		
//		["SnapshotArray","set","snap","snap","snap","get","snap","snap","get"]
//				[[1],[0,15],[],[],[],[0,2],[],[],[0,0]]
						
//		String[] str = {"SnapshotArray","snap","snap","get","set","snap","set"};
//		int[][] input = {{4},{},{},{3,1},{2,4},{},{1,4}};
		
		String[] str = {"SnapshotArray","set","snap","snap","snap","get","snap","snap","get"};
		int[][] input = {{1},{0,15},{},{},{},{0,2},{},{},{0,0}};
		int k =0;
		Test testClass = null;
		for(String s : str) {
			if(s.equals("SnapshotArray")) {
				testClass = new Test(input[k][0]);
			}else if(s.equals("set")) {
				testClass.set(input[k][0], input[k][1]);
			}else if(s.equals("snap")) {
				System.out.println(testClass.snap());
			}else if(s.equals("get")) {
				System.out.println(testClass.get(input[k][0], input[k][1]));
			}
			k++;
		}
		
	}

}
