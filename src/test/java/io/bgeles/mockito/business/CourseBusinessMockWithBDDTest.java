package io.bgeles.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import io.bgeles.mockito.services.CourseService;

class CourseBusinessMockWithBDDTest {

	CourseService mockService;
	CourseBusiness business;
	List<String> courses = new ArrayList<>();

	@BeforeEach
	void setup() {
		// Given /Arrange
		mockService = mock(CourseService.class);
		business = new CourseBusiness(mockService);

		courses = Arrays.asList("REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
				"Agile Desmistificado com Scrum, XP, Kanban e Trello", "Spotify Engineering Culture Desmistificado",
				"REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
				"Docker do Zero à Maestria - Contêinerização Desmistificada",
				"Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
				"Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
				"Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
				"REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
				"Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
				"Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
	}

	@Test
	void testCpursesRelatedToSpring_When_UsingMock() {

		// Given
		given(mockService.retrieveCourse("Leandro")).willReturn(courses);
		// Arrange
		List<String> filteredCourses = business.retrieveCourseRelatedToSpring("Leandro");
		// Then
		assertThat(filteredCourses.size(), is(4));
	}

	@Test
	@DisplayName("Delete Courses not Related to Spring Using Mockito should call Method")
	void testDeleteCoursesNotRelatedToSpring_UsingMocketoVerify_Should_CallMethod_deleteCourse() {
		// Given
		given(mockService.retrieveCourse("Leandro")).willReturn(courses);
		// Arrange
		business.deleteCoursesNotRelatedToSpring("Leandro");
		// Then
		verify(mockService).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		verify(mockService, atLeastOnce()).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		verify(mockService, atLeast(1)).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		verify(mockService, times(1)).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		verify(mockService, never()).deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");
	}

	@Test
	@DisplayName("Delete Courses not Related to Spring Using Mockito should call Method deleteCourse V2")
	void testDeleteCoursesNotRelatedToSpring_UsingMocketoVerify_Should_CallMethod_deleteCourseV2() {
		// Given
		given(mockService.retrieveCourse("Leandro")).willReturn(courses);
		// Arrange
		business.deleteCoursesNotRelatedToSpring("Leandro");
		// Then
//		verify(mockService).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		then(mockService).should().deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		then(mockService).should().deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		then(mockService).should(never()).deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");
	}

	@Test
	@DisplayName("Delete Courses not Related to Spring Using Mockito should call Method deleteCourse V2 and ArgumentCaptur")
	void testDeleteCoursesNotRelatedToSpring_UsingMocketoVerify_Should_CallMethod_deleteCourseV2_argumentCaptur() {
		// Given

		courses = Arrays.asList("Agile Desmistificado com Scrum, XP, Kanban e Trello",
				"REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");

		String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

		given(mockService.retrieveCourse("Leandro")).willReturn(courses);
		// Arrange
		business.deleteCoursesNotRelatedToSpring("Leandro");
		// Then
//		verify(mockService).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		then(mockService).should().deleteCourse(argumentCaptor.capture());
		assertThat(argumentCaptor.getValue(), is(agileCourse));
	}

	@Test
	@DisplayName("Delete Courses not Related to Spring Using Mockito should call Method deleteCourse V2 and Multiples ArgumentCaptur")
	void testDeleteCoursesNotRelatedToSpring_UsingMocketoVerify_Should_CallMethod_deleteCourseV2_MultiargumentCaptur() {
		// Given

		courses = Arrays.asList("REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
				"Agile Desmistificado com Scrum, XP, Kanban e Trello", "Spotify Engineering Culture Desmistificado",
				"REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
				"Docker do Zero à Maestria - Contêinerização Desmistificada",
				"Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
				"Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
				"Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
				"REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
				"Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
				"Microsserviços do 0 com Spring Cloud, Kotlin e Docker");

		String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

		given(mockService.retrieveCourse("Leandro")).willReturn(courses);
		// Arrange
		business.deleteCoursesNotRelatedToSpring("Leandro");
		// Then
//		verify(mockService).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		then(mockService).should(times(7)).deleteCourse(argumentCaptor.capture());
		assertThat(argumentCaptor.getAllValues().size(), is(7));
	}
}
