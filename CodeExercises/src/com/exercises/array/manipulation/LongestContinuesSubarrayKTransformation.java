package com.exercises.array.manipulation;

import java.util.Arrays;

public class LongestContinuesSubarrayKTransformation {

	
	public int getLongestContinuesSubarrrayKTransformation(int[] input, int k) {
		int max = 0;
		int windowStart = 0;
		//1  2  3  4  5  6  7  8  9  10 11
		//0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1
		//s  e
		System.out.println("k: " + k + ", Input: " + Arrays.toString(input));
		for(int windowEnd = 0; windowEnd < input.length; windowEnd++) {
			if(input[windowEnd] == 0) {
				k--;
			}
			
			if(k < 0) {
				if(input[windowStart] == 0) {
					k++;
				}
				windowStart++;
			}
			max = Math.max(max, windowEnd - windowStart + 1);
		}
		
		return max;
	}
}
