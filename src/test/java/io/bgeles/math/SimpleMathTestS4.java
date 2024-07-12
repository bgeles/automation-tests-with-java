package io.bgeles.math;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Test Math Operation in SimpleMathS4 Class")
class SimpleMathTestS4 {

	private SimpleMath math;

	@BeforeEach
	void beforeEachMethod() {
		System.out.println("Running @BeforeEach method!");
		math = new SimpleMath();
	}

	@ParameterizedTest
	@ValueSource(strings = { "Pedro", "Bruno", "Abilio" })
	void testValueSource(String firstName) {
		System.out.println(firstName);
		assertNotNull(firstName);
	}

	@DisplayName("Test Division beteween two double [firstNumber, secondNumber, expected]")
	@ParameterizedTest
	// @MethodSource("testDivisionInputParameters")
	// @CsvSource({ "6.2, 2, 3.1", "71, 14, 5.07", "18.3, 3.1, 5.90" })
	// @CsvSource({ "Pelé, Football" , "Senna, F1", "Keith Moon, ' ' " })
	@CsvFileSource(resources = "/testDivision.csv")
	void testDivide(double firstNumber, double secondNumber, double expected) {
		Double actual = math.division(firstNumber, secondNumber);
		Assertions.assertEquals(expected, actual, 2D, () -> "The testDivide() did not produce expected result");
	}

//	public static Stream<Arguments> testDivisionInputParameters() {
//		return Stream.of(Arguments.of(6.2D, 2D, 3.1D), Arguments.of(71D, 14D, 5.07D), Arguments.of(18.3D, 3.1D, 5.90D));
//	}

}
