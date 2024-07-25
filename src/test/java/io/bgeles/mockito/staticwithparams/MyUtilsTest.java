package io.bgeles.mockito.staticwithparams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class MyUtilsTest {

	@Test
	@DisplayName("shouldMockStaticMethodWithParams")
	void shouldMockStaticMethodWithParams() {
		try (MockedStatic<MyUtils> mockedStatic = mockStatic(MyUtils.class)) {
			mockedStatic.when(() -> MyUtils.getWelcomeMessage(eq("Bruno"), anyBoolean())).thenReturn("howdy Bruno!");
			String result = MyUtils.getWelcomeMessage("Bruno", false);
			assertEquals("howdy Bruno!", result);
		}

		// Given
		// Arrange
		// Then
	}

}
