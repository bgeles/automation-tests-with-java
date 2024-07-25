package io.bgeles.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListWithBDDTest {

	@Test
	void testMockingList_When_SizeIsCalled_shouldreturn10() {
		// Given
		List<?> list = mock(List.class);
		given(list.size()).willReturn(10);
		// Arrange
		// Then
		assertThat(list.size(), is(10));
	}

	@Test
	void testMockingList_When_SizeIsCalled_shouldreturnMultipleValues() {
		// Given
		List<?> list = mock(List.class);
		given(list.size()).willReturn(10).willReturn(20);
		// Arrange
		// Then
		assertThat(list.size(), is(10));
		assertThat(list.size(), is(20));
		assertThat(list.size(), is(20));

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
		given(list.get(anyInt())).willReturn("Teste");
		// Arrange
		// Then
		assertThat( list.get(anyInt()),is("Teste"));
		assertThat( list.get(anyInt()),is("Teste"));

	}

	@Test
	void testMockingList_When_ThrowsAnException() {
		// Given
		List<String> list = mock(List.class);

		// if you are using argument matchers, all arguments
		// have to be provideded by matchers
		given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar"));
		// Arrange
		// Then
		assertThrows(RuntimeException.class, () -> list.get(anyInt()), () -> "Should have throw an RuntimeException");

	}
}
