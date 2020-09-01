package com.exercises.array.manipulation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class MostFrequentNumbersTest {
	MostFrequentNumbers mfn = new MostFrequentNumbers();
	
	@Test
	void test() {
		int[] nums = new int[] {1, 1, 1, 2, 2, 3};
		List<Integer> result = mfn.getMostFrequetnNumbersPriorityQueue(nums, 2);
		System.out.println("result: " + result.toString());
		assertEquals(2, result.size());
		assertTrue(result.contains(2));
		assertTrue(result.contains(1));
		assertFalse(result.contains(3));
		
	}

}
