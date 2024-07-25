package io.bgeles.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class OrderServiceTest {

	private final OrderService service = new OrderService();
	private final UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4fc1-a71c-9905a8043dac");
	private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2023, 7, 4, 15, 50);

	@Test
	@DisplayName("Should Includ UUID in OrderID")
	void testShouldIncludeRandonOrderId_When_NoOrderId_ShouldIdExists() {
		// Given
		try (MockedStatic<UUID> mockedUuid = Mockito.mockStatic(UUID.class)) {

			mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);
			// Arrange
			Order result = service.createOrder("Macbook Pro", 2L, null);
			// Then
			assertEquals(defaultUuid.toString(), result.getId());
		}

	}

	@Test
	@DisplayName("Should Includ LocalDateTime as createdDate")
	void testShouldIncludeCreatedTime_When_CreateANewOrder() {
		// Given
		try (MockedStatic<LocalDateTime> mockedUuid = Mockito.mockStatic(LocalDateTime.class)) {

			mockedUuid.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);
			// Arrange
			Order result = service.createOrder("Macbook Pro", 2L, null);
			// Then
			assertEquals(defaultLocalDateTime, result.getCreationDate());
		}

	}

}
