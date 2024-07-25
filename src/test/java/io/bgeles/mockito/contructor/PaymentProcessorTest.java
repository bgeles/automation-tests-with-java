package io.bgeles.mockito.contructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

class PaymentProcessorTest {

	@Test
	void testMockObjectContructor() {
		try (MockedConstruction<PaymentProcessor> mocked = mockConstruction(PaymentProcessor.class, (mock, context) -> {
			when(mock.chargeCustomer(anyString(), any(BigDecimal.class))).thenReturn(BigDecimal.TEN);
		})) {

			CheckoutService service = new CheckoutService();

			// When
			BigDecimal result = service.purchaseProduct("Macbook Pro", "42");

			// Then
			assertEquals(BigDecimal.TEN, result);
			assertEquals(1, mocked.constructed().size());
		}
	}

	@Test
	@DisplayName("Test Constructor Without Constructor")
	void testABC_When_XYZ_Should() {
		// Given
		PaymentProcessor pp = new PaymentProcessor();
		String customerId = "customerId - Teste";
		BigDecimal bd = new BigDecimal(20);
		// Arrange
		BigDecimal result = pp.chargeCustomer(customerId, bd);
		// Then

		assertEquals(BigDecimal.ZERO, result);
	}
}
