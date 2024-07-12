package io.bgeles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import io.bgeles.math.SimpleMath;

@Order(2)
class DemoRepeatedTest {

	private SimpleMath math;

	@BeforeEach
	void beforeEachMethod() {
		System.out.println("Running @BeforeEach method!");
		math = new SimpleMath();
	}

	@RepeatedTest(value = 3, name = "{displayName}. Repetition {currentRepetition} of {totalRepetitions}" )
	@DisplayName("Test Division by 0 Throw Exception")
	void testDivision_When_FirstNumberIsDivideByZero_ShouldThrowArithimeticException(RepetitionInfo repetitionInfo,
			TestInfo testInfo) {

		System.out.println("Repetition N: " + repetitionInfo.getCurrentRepetition() + " of  "
				+ repetitionInfo.getTotalRepetitions());

		System.out.println("RUNNING : " + testInfo.getDisplayName());
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
