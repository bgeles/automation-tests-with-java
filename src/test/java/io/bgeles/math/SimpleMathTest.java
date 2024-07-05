package io.bgeles.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleMathTest {

	@Test
	void testSum() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double actual = math.sum(firstNumber, secondNumber);
		Double expected = 8.2D;
		Assertions.assertEquals(expected, actual, () -> "The testSum() did not produce expected result");
		Double notExpected = 9.3D;
		Assertions.assertNotEquals(notExpected, actual);
		Assertions.assertNotNull(actual);
	}

	@Test
	void testSubtract() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double actual = math.sum(firstNumber, secondNumber);
		Double expected = 8.2D;
		Assertions.assertEquals(expected, actual, () -> "The testSum() did not produce expected result");
		Double notExpected = 9.3D;
		Assertions.assertNotEquals(notExpected, actual);
		Assertions.assertNotNull(actual);
	}

	@Test
	void testMultiply() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double actual = math.multiplication(firstNumber, secondNumber);
		Double expected = 12.4D;
		Assertions.assertEquals(expected, actual, () -> "The testMultiply() did not produce expected result");
		Double notExpected = 9.3D;
		Assertions.assertNotEquals(notExpected, actual);
		Assertions.assertNotNull(actual);
	}

	@Test
	void testDivide() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double actual = math.division(firstNumber, secondNumber);
		Double expected = 3.1D;
		Assertions.assertEquals(expected, actual, () -> "The testDivide() did not produce expected result");
		Double notExpected = 9.3D;
		Assertions.assertNotEquals(notExpected, actual);
		Assertions.assertNotNull(actual);
	}

	@Test
	void testAverage() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double actual = math.mean(firstNumber, secondNumber);
		Double expected = 4.1D;
		Assertions.assertEquals(expected, actual, () -> "The testAverage() did not produce expected result");
		Double notExpected = 9.3D;
		Assertions.assertNotEquals(notExpected, actual);
		Assertions.assertNotNull(actual);
	}

	@Test
	void testSquareRoot() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 16D;
		Double actual = math.squareRoot(firstNumber);
		Double expected = 4D;
		Assertions.assertEquals(expected, actual, () -> "The testSquareRoot() did not produce expected result");
		Double notExpected = 9.3D;
		Assertions.assertNotEquals(notExpected, actual);
		Assertions.assertNotNull(actual);
	}

}
