package com.arrays.medium;

public class MergeSort {

	public static void merge(int[] array, int s, int e, int mid) {
		int[] temp = new int[e-s+1];
		int i=s, j = mid+1, k=0;
		while(i<=mid && j<=e) {
			if(array[i] <= array[j]) {
				temp[k++] = array[i++];
			}else{
				temp[k++] = array[j++];
			}
		}
		while(i<=mid) {
			temp[k++] = array[i++];
		}
		while(j<=e) {
			temp[k++] = array[j++];
		}
		for(int h=0; h<k;h++) {
			array[s+h] = temp[h];
		}
	}
	public static void mergeSortSplit(int[] array, int s, int e) {
		if(s < e) {
			int mid  = (s+e)/2;
			mergeSortSplit(array,s,mid);
			mergeSortSplit(array,mid+1,e);
			merge(array, s, e, mid);
		}
	}
	  public static int[] mergeSort(int[] array) {
	    mergeSortSplit(array, 0, array.length-1);
	    return array;
	  }
	public static void main(String[] args) {
		int[] A = {5,5,6,7,8,6,7,8,2,3,4,3,2, 1,1};
		System.out.println(mergeSort(A));
		for(int ele: A) System.out.print(ele);
	}

}
