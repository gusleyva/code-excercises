package com.exercises.array.manipulation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MInSubarraySumTest {

	MinSubarraySum minSubArraySum = new MinSubarraySum();
	@Test
	void test() {
		int[] input = new int[] {4,2,2,7,8,1,2,8,10};
		int minWindowSize = minSubArraySum.getMinSubarraySum(input, 8);
		assertEquals(1, minWindowSize);
	}

}
