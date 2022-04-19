package com.Google.prep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RaceCar {

	public static void main(String[] args) {
		Queue<int[]> q = new LinkedList<int[]>();
		int target = 100;
		int ans = 0;
		
		Set<String> set = new HashSet<String>();
		
		q.add(new int[]{0,1,0});
		
		while(!q.isEmpty() ) {
			int[] arr = q.poll();
			int currPos = arr[0];
			int currSpeed = arr[1];
			int currSteps = arr[2];
			int nextPos = (currPos + currSpeed);
			if(nextPos == target) {
				ans = currSteps;
				break;
			}
			if(set.contains(currPos +","+currSpeed)) continue;
			
			set.add(currPos +","+currSpeed);
			
			if(nextPos < target) {
				if(set.contains(nextPos +","+currSpeed*2)){
					q.add(new int[]{nextPos,currSpeed*2,currSteps+1});
				}
			}
			int nextSpeed = currSpeed > 0 ? 1 : -1;
			if(set.contains(nextPos +","+nextSpeed)){
				q.add(new int[]{nextPos,nextSpeed,currSteps+1});
			}
			
		}

		System.out.println(ans);
	}

}
