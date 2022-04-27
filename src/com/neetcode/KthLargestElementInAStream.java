package com.neetcode;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

	public static class KthLargest {
	PriorityQueue<Integer> kEleQueue;
    int kthEle;
    public KthLargest(int k, int[] nums) {
        kthEle = k;
        kEleQueue = new PriorityQueue<Integer>();
        
        for(int num: nums) {
            if(kEleQueue.size() < k) kEleQueue.add(num);
            else{
            	if(kEleQueue.peek() < num) {
	                kEleQueue.poll();
	                kEleQueue.add(num);
            	}
            }
            
        }
    }
    
    public int add(int val) {
        if(kEleQueue.size() < kthEle) kEleQueue.add(val);
        else{
        	if(kEleQueue.peek() < val) {
                kEleQueue.poll();
                kEleQueue.add(val);
        	}
        }
        return kEleQueue.peek();
    }
	}
	public static void main(String[] args) {
//				[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
		String[] instructions = {"KthLargest", "add", "add", "add", "add", "add"};
		int[][] arr = {{3},{4,5,8,2}, {3},{5},{10},{9},{4}};
		KthLargest obj = null;
		int k = 0;
		for(String instruction: instructions) {
			if(instruction.equals("KthLargest")) {
				obj = new KthLargest(arr[k][0],arr[k+1]);
				k++;
			}else {
				System.out.println(obj.add(arr[k][0]));
			}
			k++;
		}
		

	}

}
