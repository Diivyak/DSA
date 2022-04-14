package com.recursion;

import java.util.ArrayList;

public class UniquePermutationsNumeric {

	public static ArrayList<int[]> output;
	public static void getPermutationsHelper(int[] arr, int[] result, int idx, int len) {
		if(idx == len) {
			int[] temp = new int[len];
			for(int i=0; i<len;i++) 
				temp[i] = result[i];
			output.add(temp);
			return;
		}
		for(int i=0; i<10;i++) {
			if(arr[i] != 0) {
				arr[i]--;
				result[idx] = i;
				getPermutationsHelper(arr, result, idx+1, len);
				arr[i]++;
			}
		}
	}
	public static ArrayList<int[]> getPermutations(int[] a) {
		output = new ArrayList<int[]>();
		int len = a.length;
		int[] res = new int[len];
		int[] freq = new int[10];
		for(int i=0; i<len;i++) {
			freq[a[i]]++;
		}
		getPermutationsHelper(freq, res, 0, len);
		
		return output;
	}
	public static void main(String[] args) {
		getPermutations(new int[] {1,1,2,3});
		for(int[] ele: output) {
			for(int j=0; j<ele.length;j++)
				System.out.print(ele[j]+ " ");
			System.out.println();
		}
	}

}
