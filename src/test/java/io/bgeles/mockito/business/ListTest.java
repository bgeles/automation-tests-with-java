package io.bgeles.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {

	@Test
	void testMockingList_When_SizeIsCalled_shouldreturn10() {
		// Given
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(10);
		// Arrange
		// Then
		assertEquals(10, list.size());
	}

	@Test
	void testMockingList_When_SizeIsCalled_shouldreturnMultipleValues() {
		// Given
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20);
		// Arrange
		// Then
		assertEquals(10, list.size());
		assertEquals(20, list.size());
		assertEquals(20, list.size());

	}

	@Test
	void testMockingList_When_GetIsCalled_shouldreturnMultipleTeste() {
		// Given
		List<String> list = mock(List.class);
		when(list.get(0)).thenReturn("Teste");
		// Arrange
		// Then
		assertEquals("Teste", list.get(0));
		assertNull(list.get(1));

	}

	@Test
	void testMockingList_When_GetIsCalledWithArgumentMatcher_shouldreturnMultipleTeste() {
		// Given
		List<String> list = mock(List.class);

		// if you are using argument matchers, all arguments
		// have to be provideded by matchers
		when(list.get(anyInt())).thenReturn("Teste");
		// Arrange
		// Then
		assertEquals("Teste", list.get(anyInt()));
		assertEquals("Teste", list.get(anyInt()));

	}

	@Test
	void testMockingList_When_ThrowsAnException() {
		// Given
		List<String> list = mock(List.class);

		// if you are using argument matchers, all arguments
		// have to be provideded by matchers
		when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar"));
		// Arrange
		// Then
		assertThrows(RuntimeException.class, () -> list.get(anyInt()), () -> "Should have throw an RuntimeException");

	}
}
