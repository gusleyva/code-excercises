package com.exercises.array.manipulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LongestContiguous {

	/**
	 * 
	 * @param input [0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1]
	 * @param k = 2
	 * @return
	 */
	public int getLongestContiguous(int[] input, int k) {
		if(input.length == 0)
			return 0;
		
		int left = 0, right = 0;
		while(right < input.length) {
			if(input[right] == 0) {
				k--;
			}
			
			//[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1]
			//             s           e
			// k = 2, 
			if(k < 0) {
				if(input[left] == 0) {
					k++;
				}
				left++;
			}
			
			right++;
		}
		
		return right - left;
	}
}
