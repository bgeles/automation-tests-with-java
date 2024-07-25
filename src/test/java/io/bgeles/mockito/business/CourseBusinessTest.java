package io.bgeles.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.bgeles.mockito.services.CourseService;
import io.bgeles.mockito.services.stubs.CourseServiceStub;

class CourseBusinessTest {

	@Test
	void testCpursesRelatedToSpring_When_UsingStub() {
		// Given
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);
		// Arrange
		List<String> filteredCourses = business.retrieveCourseRelatedToSpring("Leandro");
		// Then
		assertEquals(4, filteredCourses.size());
	}

	@Test
	void testCpursesRelatedToSpring_When_UsingStubFooBarStudent() {
		// Given
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);
		// Arrange
		List<String> filteredCourses = business.retrieveCourseRelatedToSpring("Foo Bar");
		// Then
		assertEquals(0, filteredCourses.size());
	}

}
