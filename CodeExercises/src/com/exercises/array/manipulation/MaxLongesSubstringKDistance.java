package com.exercises.array.manipulation;

import java.util.HashMap;
import java.util.Map;

public class MaxLongesSubstringKDistance {

	public int getMaxLongesSubstringKDistance(String s, int k) {
		Map<Character, Integer> currentWindow = new HashMap<>();
		int maxWindow = Integer.MIN_VALUE;
		int windowStart = 0;
		char[] input = s.toCharArray();
		for(int windowEnd = 0; windowEnd < input.length; windowEnd++) {
			currentWindow.put(input[windowEnd], currentWindow.getOrDefault(input[windowEnd], 0) + 1);
			while(currentWindow.size() > k) {
				currentWindow.put(input[windowStart], currentWindow.get(input[windowStart]) - 1);
				if(currentWindow.get(input[windowStart]) <= 0) {
					currentWindow.remove(input[windowStart]);
				}
				windowStart++;
			}
			maxWindow = Math.max(maxWindow, windowEnd - windowStart + 1);
		}
		
		return maxWindow;
	}
}
