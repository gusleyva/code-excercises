package com.exercises.array.manipulation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestContinuesSubarrayKTransformationTest {
	LongestContinuesSubarrayKTransformation lcskt = new LongestContinuesSubarrayKTransformation();
	@Test
	void testGetLongestContinuesSubarrrayKTransformation() {
		int[] input = new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
		int k = 2;
		int max = lcskt.getLongestContinuesSubarrrayKTransformation(input, k);
		assertEquals(6, max);
	}

}
