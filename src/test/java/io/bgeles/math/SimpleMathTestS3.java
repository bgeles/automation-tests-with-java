package io.bgeles.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Math Operation in SimpleMath Class")
class SimpleMathTestS3 {

	private SimpleMath math;

	@BeforeAll
	static void setup() {
		System.out.println("Running @BeforeAll method!");
	}

	@AfterAll
	static void cleanup() {
		System.out.println("Running @AfterAll method!");
	}

	@BeforeEach
	void beforeEachMethod() {
		System.out.println("Running @BeforeEach method!");
		math = new SimpleMath();
	}

	@AfterEach
	void afterEachMethod() {
		System.out.println("Running @AfterEach method!");
	}

	@Test
	@DisplayName("Test 6.2 + 2 = 8.2")
	void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEigthDotTwo() {
		System.out.println("Running @AfterAll method!");
		// Given /Arrange
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double expected = 8.2D;
		Double notExpected = 9.3D;
		// When /Act
		Double actual = math.sum(firstNumber, secondNumber);
		// Then /Assert
		Assertions.assertEquals(expected, actual, () -> "The testSum() did not produce expected result");
		Assertions.assertNotEquals(notExpected, actual);
		Assertions.assertNotNull(actual);
	}

	@Test
	@DisplayName("Test 6.2 - 2 = 4.2")
	void testSubtract() {
		System.out.println("Running @AfterAll method!");
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double actual = math.subtraction(firstNumber, secondNumber);
		Double expected = 4.2D;
		Assertions.assertEquals(expected, actual, () -> "The tesSubstract() did not produce expected result");
		Double notExpected = 9.3D;
		Assertions.assertNotEquals(notExpected, actual);
		Assertions.assertNotNull(actual);
	}

	@Test
	@DisplayName("Test 6.2 * 2 = 12.4")
	void testMultiply() {
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
	@DisplayName("Test 6.2 + 2 = 3.1")
	void testDivide() {
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
	@DisplayName("Test (6.2 + 2)/2  = 4.1")
	void testAverage() {
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
	@DisplayName("Test 16 rootSquare = 4")
	void testSquareRoot() {
		double firstNumber = 16D;
		Double actual = math.squareRoot(firstNumber);
		Double expected = 4D;
		Assertions.assertEquals(expected, actual, () -> "The testSquareRoot() did not produce expected result");
		Double notExpected = 9.3D;
		Assertions.assertNotEquals(notExpected, actual);
		Assertions.assertNotNull(actual);
	}

//	@Disabled("TODO: We need implement it")
	@Test
	@DisplayName("Test Division by 0 Throw Exception")
	void testDivision_When_FirstNumberIsDivideByZero_ShouldThrowArithimeticException() {
		// Given
		double firstNumber = 5D;
		double secondNumber = 0D;
		String expectedMessage = "Impossible to divide by zero!";
		// When /Then
		ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
			math.division(firstNumber, secondNumber);
		}, () -> "Division by zero should throw an ArithmeticException");
		assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected Exception Message");
	}

}
