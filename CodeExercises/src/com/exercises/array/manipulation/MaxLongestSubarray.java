package com.exercises.array.manipulation;

public class MaxLongestSubarray {

	public int getMaxLongestSubarray(int[] input, int k) {
		int windowStart = 0;
		int windowEnd = 0;
		while(windowEnd < input.length) {
			if(input[windowEnd] == 0) {
				k--;
			}

			if(k < 0) {
				if(input[windowStart] == 0) {
					k++;
				}
				windowStart++;
			}
			
			windowEnd++;
		}
		
		return windowEnd - windowStart;
	}
}
