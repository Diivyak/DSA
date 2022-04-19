package com.Google.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DetectSquares {

	public static Map<Integer, ArrayList<Integer>> map;
	public static int[][] pairCount;
	public DetectSquares() {
		map = new HashMap<Integer, ArrayList<Integer>>();
		pairCount = new int[1001][1001];
	}
	
	public static void add(int[] points) {
		int x = points[0];
		int y = points[1];
		if(!map.containsKey(x)) {
			map.put(x, new ArrayList<Integer>());
			map.get(x).add(points[1]);
		}
		pairCount[x][y]++;
		return;
	}
	public static int count(int[] points) {	
		int x = points[0];
		int y = points[1];
		int noOfSquares  = 0;
		for(Integer y1: map.getOrDefault(x, new ArrayList<Integer>())) {
			
			if(y == y1) continue;
			int diff = Math.abs(y1- y);
			if(x+diff <= 1000) noOfSquares += pairCount[x+diff][y] * pairCount[x+diff][y1] *  pairCount[x][y1];
			if(x-diff >= 0) noOfSquares += pairCount[x-diff][y] * pairCount[x-diff][y1] *  pairCount[x][y1];
		}
		return noOfSquares;
	}
	
	public static void main(String[] args) {
		String[] inputs = {"DetectSquares", "add", "add", "add", "count", "count", "add", "count"};
		int[][] vals = new int[][]{{},{3, 10}, {11, 2}, {3, 2}, {11, 10}, {14, 8}, {11, 2}, {11, 10}};
		int k =0;
		for(String i : inputs) {
			if(i.equals("DetectSquares")) {
				new DetectSquares();
			}else if( i.equals("add")) {
				add(new int[] {vals[k][0], vals[k][1]});
			}else {
				System.out.println(count(new int[] {vals[k][0], vals[k][1]}));
			}
			k++;
		}

	}

}
