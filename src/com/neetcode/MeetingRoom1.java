package com.neetcode;

import java.util.Arrays;

public class MeetingRoom1 {

	public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0] - b[0]);
        
        int n = intervals.length;
        for(int i=0; i+1<n;i++) {
            if((intervals[i+1][0] < intervals[i][1]) || (intervals[i+1][1]< intervals[i][1])) {
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		int[][] arr = {{0,30},{5,10},{15,20}};
		System.out.println(canAttendMeetings(arr));
	}

}
	