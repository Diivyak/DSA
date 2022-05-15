package com.arrays.easy;

public class SearchInRotatedSortedArray {

	public static int getPeakIdx(int[] nums) {
        int n = nums.length;
        int l = 0, r = nums.length-1;
        while(l <r) {
            int mid = l+ (r-l)/2;
            if(mid > 0 && mid <n && nums[mid] < nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            r = mid-1;
        }
        l = 0;
        r = n-1;
        while(l < r) {
            int mid = l+ (r-l)/2;
            if(mid > 0 && mid <n && nums[mid] < nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            l = mid+1;
        }
        return l;
    }
    public static int getIdx(int[] nums, int l, int r, int target) {
        while(l <r) {
            int mid = l+ (r-l)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target) {
                r= mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    public static int search(int[] nums, int target) {
        int peak = getPeakIdx(nums);
        if(nums[peak] == target)
            return peak;
        int ans = -1;
        ans = getIdx(nums, 0, peak, target);
        if(ans == -1) {
            return getIdx(nums, peak, nums.length, target);
        }
        return ans;
    }
	public static void main(String[] args) {
		int[] arr = {4,5,6,7,0,1,2};
		int target = 0;
		System.out.println(search(arr, target));
		

	}

}
