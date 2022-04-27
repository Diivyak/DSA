package com.neetcode;

import java.util.PriorityQueue;

public class LastStoneWeight {

	public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>((a , b) -> b-a);
        for(int stone: stones) {
            p.add(stone);
        }
        
        while(p.size() > 1 ) {
            int num1 = p.poll();
            int num2 = p.poll();
            if(num1 != num2) {
                if(num1 > num2) p.add(num1- num2);
                if(num2 > num1) p.add(num2- num1);
            }
        }
        
        return  p.isEmpty() ? 0 : p.poll();
    }
	public static void main(String[] args) {
		int[] stones = {2,7,4,1,8,1};
		System.out.println(lastStoneWeight(stones));
	}

}
