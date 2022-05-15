package com.arrays.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class PairsWithSpecificDiff {

	static int[][] findPairsWithGivenDifference(int[] arr, int k) {
	       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    

	      for(int num: arr) {
	        map.put(num-k, num);
	      }
	      ArrayList<ArrayList<Integer>> output = new ArrayList<>();
	      for(int num :arr) {
	        if(map.containsKey(num)) {
	          ArrayList<Integer> list = new ArrayList<>();
	          list.add(map.get(num));
	          list.add(num);
	          output.add(list);
	        }
	      }
	    int[][] ans = new int[output.size()][2];
	    int l = 0;
	    for(ArrayList<Integer> list: output) {
	      ans[l++] = new int[]{list.get(0), list.get(1)};
	    }
	    return ans;
	  }


	  public static void main(String[] args) {
	    int[] arr = {0, -1, -2, 2, 1};
	    int[][] output = findPairsWithGivenDifference(arr, 1);
	    for(int[] nums: output) {
	      System.out.println(nums[0] +" "+nums[1]);
	    }
	  }


}
