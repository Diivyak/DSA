package com.algoexpert;

public class SortedSquaredArray {

  public static int[] sortedSquaredArray(int[] array) {
		int n = array.length;
		int[] squareArr = new int[n];
		for(int i=0; i<n;i++) squareArr[i] = (array[i] * array[i]);
		return squareArr;
  }
	public static void main(String[] args) {
		int[] A = {1,2,3};
		int[] output = sortedSquaredArray(A);
		for(int i=0; i<output.length;i++) System.out.print(output[i] +" ");

	}

}
