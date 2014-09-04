package com.omega.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class ArraysTester {
	@Test
	public void testArraysSort() {
		int[] numbers	= {6,4,3,2,1,5};
		int[] expectedOutput = {1,2,3,4,5,6};
		Arrays.sort(numbers);
		assertArrayEquals(expectedOutput, numbers);
	}
	
	@Test(expected=NullPointerException.class)
	public void testArraysSortwithNullValue() {
		int[] numbers	= null;
		Arrays.sort(numbers);
	}

	@Test(timeout=150)
	public void testArraysTimeout() {
		Random rnd = new Random();
		
		for (int i = 0; i < 1200000; i++) {
			int[] numbers = {i, i+rnd.nextInt(100), i-rnd.nextInt(50)};
			Arrays.sort(numbers);
		}
	}
}
