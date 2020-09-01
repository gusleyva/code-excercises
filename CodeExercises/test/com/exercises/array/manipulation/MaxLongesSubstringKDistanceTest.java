package com.exercises.array.manipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxLongesSubstringKDistanceTest {
	MaxLongesSubstringKDistance maxLongesSubstringKDistance = new MaxLongesSubstringKDistance();
	
	@Test
	public void getMaxLongesSubstringKDistance() {
		int maxLongestSubstring = maxLongesSubstringKDistance.getMaxLongesSubstringKDistance("AAAHHIBC", 2);
		assertEquals(maxLongestSubstring, 5);
	}
}
