package com.neetcode;

import java.util.PriorityQueue;

public class LongestConsecutiveSequence {

//  public int longestConsecutive(int[] nums) {
//  HashSet<Integer> set = new HashSet<Integer>();
//  int n = nums.length;
//  for(int num :nums) set.add(num);
//  int maxLen = 0;
//  for(int i=0; i<n;i++) {
//      int currLen = 1;
//      int currVal = nums[i];
//      if(!set.contains(currVal-1)) {

//          while(set.contains(currVal+1)) {
//              currLen++;
//              currVal  =currVal+1;
//          }
//          maxLen = Math.max(maxLen, currLen);
//      }

//  }
//  return maxLen;
//}
	public static int longestConsecutive(int[] nums) {
		if (nums.length == 0)
			return 0;
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		int maxLen = 0;
		for (int num : nums)
			p.add(num);

		int num = p.poll();
		int localMax = 1;
		while (!p.isEmpty()) {
			int cur = p.poll();

			if (num == cur)
				continue;
			else if (cur == num + 1)
				localMax++;
			else
				localMax = 1;
			maxLen = Math.max(maxLen, localMax);
			num = cur;
		}
		maxLen = Math.max(maxLen, localMax);
		return maxLen;
	}

	public static void main(String[] args) {
//		int[] arr = {100,4,200,1,3,2};
		int[] arr = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		System.out.println(longestConsecutive(arr));

	}

}
