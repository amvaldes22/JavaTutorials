package com.omega.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.omega.Reverser;

public class ReverserTest {
	private static final String AMAURY = "Amaury Valdes";
	private static final String expectedOutput="sedlaV yruamA";
	
	@Test
	public void testSbReverser() {
		Reverser r = new Reverser();
		String actualOutput = r.sbReverser(AMAURY);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testCharReverser() {
		Reverser r = new Reverser();
		String actualOutput = r.charReverser(AMAURY);
		assertEquals(expectedOutput, actualOutput);
	}
}
