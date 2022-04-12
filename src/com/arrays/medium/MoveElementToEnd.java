package com.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class MoveElementToEnd {

	public static void swap(List<Integer>list, int i, int j) {
		int tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
		return;
	}
	
	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
	int n = array.size();
		int i=0, j = n-1;
		while(i< j) {
			while((j > i) && array.get(j) == toMove) {
					j--;
			}
			if(array.get(i) == toMove) {
					swap(array, i, j);
			}
			i++;
		}
		
	return array;
	}
	public static void main(String[] args) {
		List<Integer> output =  new ArrayList<Integer>();
		int[] A = {1,2,3,5,6, 2,3,2,2,7};
		for(int i=0; i<A.length;i++) {
			output.add(A[i]);
		}
		output = moveElementToEnd(output, 2);
		for(Integer ele: output) {
			System.out.print(ele+ " ");
		}

	}

}
