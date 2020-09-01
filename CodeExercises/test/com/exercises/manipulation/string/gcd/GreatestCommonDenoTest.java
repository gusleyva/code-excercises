package com.exercises.manipulation.string.gcd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GreatestCommonDenoTest {

	GreatestCommonDeno gdc = new GreatestCommonDeno();
	@Test
	void test() {
		String gdcString = gdc.greatestCommonDenoStr("BABABA", "BABA");
		assertEquals("BA", gdcString);
	}

}
