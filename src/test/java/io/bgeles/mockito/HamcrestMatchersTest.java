package io.bgeles.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.*;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class HamcrestMatchersTest {

	@Test
	void testHamcrestMatchers() {
		// GIVEN
		List<Integer> scores = Arrays.asList(99, 100, 101, 105);

		// WHEN & THEN
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(100, 101));
		assertThat(scores, everyItem(greaterThan(98)));
		assertThat(scores, everyItem(lessThan(988)));

		// CHECK STRINS
		assertThat("", is(emptyString()));
		assertThat(null, is(emptyOrNullString()));

		// Arrays
		Integer[] myArray = { 1, 2, 3 };
		assertThat(myArray, arrayWithSize(3));
		assertThat(myArray, arrayContaining(1,2,3));
		assertThat(myArray, arrayContainingInAnyOrder(1,3,2));


	}

}
