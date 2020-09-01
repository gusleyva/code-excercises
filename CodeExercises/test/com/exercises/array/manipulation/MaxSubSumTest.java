package com.exercises.array.manipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxSubSumTest {
	MaxSubSum maxSubSum = new MaxSubSum();
	@Test
	public void getMaxSubArraySumTest() {
		int[] input = new int[] {4,2,1,7,8,1,2,8,1,0};
		int maxSumSubArray = maxSubSum.getMaxSubArraySum(input, 3);
		assertEquals(16, maxSumSubArray);
	}
}
