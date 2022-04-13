package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static List<List<Integer>> output;
	public static void generatePermutations(List<Integer> array, List<Integer> temp, int k, int idx) {
		if(idx >=array.size()) {
			output.add(new ArrayList<>(temp));
			return;
		}
		for(int i=0; i<array.size();i++) {
			if(temp.get(i) == -1) {
				temp.set(i, array.get(idx));
				generatePermutations(array, temp, i+1, idx+1);
				temp.set(i, -1);
			}
		}
	}
  public static List<List<Integer>> getPermutations(List<Integer> array) {
		output = new ArrayList<List<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=0; i<array.size(); i++) {
			temp.add(-1);
		}
    generatePermutations(array, temp, 0,0);
    return output;
  }
//	public static List<List<Integer>> output;
//	public static void generatePermutations(List<Integer> array, List<Integer> temp,int idx) {
//		if(idx >= array.size()) {
//			output.add(new ArrayList<>(temp));
//			return;
//		}
//		for(int i=0; i<array.size();i++) {
//				if(temp.get(i) == -1) {
//					temp.set(i, array.get(idx));
//					generatePermutations(array, temp, idx+1);
//					temp.set(i, -1);
//				}
//			}
//		}
//  public static List<List<Integer>> getPermutations(List<Integer> array) {
//		output = new ArrayList<List<Integer>>();
//		List<Integer> temp = new ArrayList<Integer>();
//		for(int i=0; i<array.size(); i++) {
//			temp.add(-1);
//		}
//    generatePermutations(array, temp, 0);
//    return output;
//  }
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		output = getPermutations(list);
	}

}
