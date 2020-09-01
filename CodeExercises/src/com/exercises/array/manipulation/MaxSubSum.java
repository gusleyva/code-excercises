package com.exercises.array.manipulation;

public class MaxSubSum {

	public int getMaxSubArraySum(int[] input, int k) {
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		
		for(int i = 0; i < input.length; i++) {
			currentSum += input[i];
			if(i >= (k - 1)) {
				maxSum = Math.max(maxSum, currentSum);
				currentSum -= input[i - (k - 1)];
				//4, 2, 1, 7, 8, 1, 2, 8, 1, 0
				//sum   7  10 16 16 11 11 11 9
			}
		}
		
		return maxSum;
	}
}
