package com.exercises.array.manipulation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestContiguousTest {

	LongestContiguous longestContiguous = new LongestContiguous
			();
	@Test
	void GetLongestContiguoustest() {
		int[] input = new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
		int maxContiguous = longestContiguous.getLongestContiguous(input, 2);
		assertEquals(6, maxContiguous);
		
		input = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
		maxContiguous = longestContiguous.getLongestContiguous(input, 3);
		assertEquals(9, maxContiguous);
	}

}
