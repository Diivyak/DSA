package com.Google;

public class MedianOfTwoSortedArrays {
	
	public static double getMedian(int[] arr1, int[] arr2) {
		int n = arr1.length, m = arr2.length;
		if(n > m)   return getMedian(arr2, arr1);
		int p = (n+m+1)/2;
		int l = 0, r = n;
		while(l<=r) {
			int mid = (l+r+1)/2;
			int yMid = p-mid;
			int x1= mid == 0 ? Integer.MIN_VALUE : arr1[mid-1];
			int x2= mid == n ? Integer.MAX_VALUE : arr1[mid];
			
			int y1 = yMid==0? Integer.MIN_VALUE :arr2[yMid-1];
			int y2 = yMid==m? Integer.MAX_VALUE :arr2[yMid];
			if(x1 > y2) {
				r = mid-1;
			}
			else if(y1 > x2) {
				l = mid+1;
			}else {
				if((n+m)%2 == 0) {
					return (Math.max(x1,  y1) + Math.min(x2, y2))/2.0;
				}else {
					return Math.max(x1, y1);
				}
			}
			
		}
		return 0.0;
	}
	
	
	public static double[] helper(int count, int n, int mid,int ans, int ele) {
		if((n)%2 == 0) {
			if(count == mid) return new double[]{0,ele};
			else if(count == mid+1) {
				ans += ele;
				return new double[]{1,(double) (ans/2.0)};
			}
		}else {
			if(count == mid+1) return new double[]{1,(double)(ele)};
		}
		return new double[]{0,ele};
	}
	public static double getMedian1(int[] A, int[] B) {
		int n = A.length, m = B.length;
		int mid = (n+m)/2, count = 0, ans = 0;
		int i=0, j=0;
		while(i<n && j <m) {
			int ele = 0;
			if(A[i] <= B[j]) {
				ele = A[i++];
			}else {
				ele = B[j++];
			}
			count++;
			double[] output = helper( count, n+m, mid, ans, ele);
			if(output[0] == 1) {
				return output[1];
			}else {
				ans = (int)output[1];
			}
		}
		while( i<n) {
			count++;
			double[] output = helper( count, n+m, mid, ans, A[i++]);
			if(output[0] == 1) {
				return output[1];
			}else {
				ans = (int)output[1];
			}
		}
		while(j<m) {
			count++;
			double[] output = helper( count, n+ m, mid, ans, B[j++]);
			if(output[0] == 1) {
				return output[1];
			}else {
				ans = (int)output[1];
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,5};
		int[] b = {4};
		System.out.println(getMedian(a,b));

	}

}
