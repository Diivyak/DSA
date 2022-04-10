package com.arrays.easy;

public class StudentAttendanceRecord {
	/*
	 * Student Attendance Record I You are given a string s representing an
	 * attendance record for a student where each character signifies whether the
	 * student was absent, late, or present on that day. The record only contains
	 * the following three characters:
	 * 
	 * 'A': Absent. 'L': Late. 'P': Present. The student is eligible for an
	 * attendance award if they meet both of the following criteria:
	 * 
	 * The student was absent ('A') for strictly fewer than 2 days total. The
	 * student was never late ('L') for 3 or more consecutive days. Return true if
	 * the student is eligible for an attendance award, or false otherwise.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: s = "PPALLP" Output: true Explanation: The student has fewer than 2
	 * absences and was never late 3 or more consecutive days. Example 2:
	 * 
	 * Input: s = "PPALLL" Output: false Explanation: The student was late 3
	 * consecutive days in the last 3 days, so is not eligible for the award.
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= s.length <= 1000 s[i] is either 'A', 'L', or 'P'.
	 * 
	 */
	
	public static boolean isEligibleStudent(String s) {
		boolean ans = false;
		int n = s.length();
		int count = 0;
		for(int i=0; i<n;i++) {
			if(s.charAt(i) == 'A') {
				count++;
			}
		}
		if(count < 2) {
			ans = true;
		}
		int maxCount = Integer.MIN_VALUE;
		count = 0;
		
		for(int i=0; i<n;i++) {
			if(s.charAt(i) == 'L') {
				count++;
			}else {
				maxCount = Math.max(maxCount, count);
			}
		}
		maxCount = Math.max(maxCount, count);
		if(maxCount < 3) {
			ans = true;
		}else {
			ans = false;
		}
		
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(isEligibleStudent("PPALLP"));

	}

}
