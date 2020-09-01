package com.exercises.array.sum;

public class MaxContiguousSubarraySum {

	public int maxContiguousSubarraySum(int[] nums) {
		int maxSoFar = nums[0];
		int maxEndingHere = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		
		return maxSoFar;
	}
}