package com.exercises.binary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class BinaryAppendTest {
	BinaryAppend ba = new BinaryAppend();
	@Test
	void testBasicScenario() {
		Long result = ba.FindBigNum(3);
		assertEquals(27L, result);
	}
	
	@Ignore
	void testBRegular() {
		Long result = ba.FindBigNum(9);
		assertEquals(28931977L, result);
	}
	
	@Test
	void testAdvanced() {
		Long result = ba.FindBigNum(20);
		assertEquals(28931977L, result);
	}

}
