package io.bgeles;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class ArraysCompareTest {

	@Test
	void test() {
		// Given
		int[] numbers = { 25, 8, 21, 32, 3 };
		int[] expectedArray = { 3, 8, 21, 25, 32 };
		// When
		Arrays.sort(numbers);
		// Then
		assertArrayEquals(numbers, expectedArray);
	}

	@Test
	@Timeout(value = 100000, unit = TimeUnit.MILLISECONDS)
	void testSortPerformance() {
		// Given
		int[] numbers = { 25, 8, 21, 32, 3 };
		for (int i = 0; i < 100000000; i++) {
			numbers[0] = i;
			Arrays.sort(numbers);

		}


	}

}
