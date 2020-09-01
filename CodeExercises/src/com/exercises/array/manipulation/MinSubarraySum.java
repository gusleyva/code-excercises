package com.exercises.array.manipulation;

public class MinSubarraySum {

	public int getMinSubarraySum(int[] input, int sum) {
		int minWindowSize = Integer.MAX_VALUE;
		int currentSum = 0;
		int windowStart = 0;
		for(int windowEnd = 0; windowEnd < input.length; windowEnd++) {
			currentSum += input[windowEnd];
			if(currentSum >= sum) {
				minWindowSize = Math.min(minWindowSize, (windowEnd - windowStart - 1)); //-1 due array start at index 0
				currentSum -= input[windowStart];
				windowStart++;
			}
		}
		return minWindowSize;
	}
}
