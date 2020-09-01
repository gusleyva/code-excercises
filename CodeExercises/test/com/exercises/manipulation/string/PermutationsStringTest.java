package com.exercises.manipulation.string;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class PermutationsStringTest {
	PermutationsString ps = new PermutationsString();
	@Test
	void testBasic() {
		String needle = "ab";
		String hystack = "bac";
		List<String> result = ps.getPermutationsMatchesInString(needle, hystack);
		System.out.println(result.toString());
		assertEquals(1, result.size());
	}
	
	@Test
	void testLowerBound() {
		String needle = "a";
		String hystack = "ab";
		List<String> result = ps.getPermutationsMatchesInString(needle, hystack);
		System.out.println(result.toString());
		assertEquals(1, result.size());
	}

	@Test
	void testNecessary() {
		String needle = "abbc";
		String hystack = "bdabcbaacb";
		List<String> result = ps.getPermutationsMatchesInString(needle, hystack);
		System.out.println(result.toString());
		assertEquals(2, result.size());
	}
	
	@Test
	void testLeetCode1() {
		String needle = "adc";
		String hystack = "dcda";
		List<String> result = ps.getPermutationsMatchesInString(needle, hystack);
		System.out.println(result.toString());
		assertEquals(1, result.size());
	}
}
