package com.Google;

import java.util.HashMap;

public class FruitsInBasket {

	public static int totalFruit(int[] fruits) {
		int n = fruits.length, i =0, j = 0;

		int maxVal = Integer.MIN_VALUE;
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        while(i <n) {
            int val = fruits[i];
            map.put(val, map.getOrDefault(val, 0)+1);
            i++;
            while(map.size() > 2) {
                int removeVal = fruits[j];
                map.put(removeVal, map.get(removeVal).intValue()-1);
                if(map.get(removeVal) == 0) map.remove(removeVal);
                j++;
            }
            maxVal = Math.max(maxVal, (i-j));
            
        }
		return maxVal;
	}

	public static void main(String[] args) {
		int[] a = {3,3,3,1,2,1,1,2,3,3,4 };
		System.out.println(totalFruit(a));

	}

}
