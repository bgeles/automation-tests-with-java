package io.bgeles.persons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.bgeles.persons.model.Person;

class PersonServiceTest {

	Person person;
	IPersonService service;

	@BeforeEach
	void setup() {
		service = new PersonService();
		person = new Person("Lilo", "Billy", "email@email.com", "IBITUBA", "Male");
	}

	@Test
	@DisplayName("When Create a Person with Sucess Show Return a Person Object")
	void testCreatePerson_WhenSucess_showudReturnPersonObject() {
		// Given
		IPersonService service = new PersonService();

		// Arrange
		Person actual = service.createPerson(person);
		// Then
		assertNotNull(actual, () -> "The createPerson() should not have returned null!");
	}

	@Test
	@DisplayName("When Create a Person with Sucess Show Container a FirstName in a Person Object")
	void testCreatePerson_WhenSucess_showudContainsFirstNameInReturnedPersonObject() {
		// Given
		// Arrange
		Person actual = service.createPerson(person);
		// Then
		assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The firstName is diferent!");
		assertEquals(person.getLastName(), actual.getLastName(), () -> "The lastName is diferent!");
		assertEquals(person.getAddress(), actual.getAddress(), () -> "The Address is diferent!");
		assertEquals(person.getGender(), actual.getGender(), () -> "The gender is diferent!");
		assertNotNull(actual.getId(), () -> "The ID is notNull !");

	}

	@Test
	@DisplayName("When Create a Person with null email")
	void testCreatePerson_WithNullEmail_shouIdThrowIllegalArgumentException() {
		// Given
		person.setEmail(null);
		// Arrange
		// Then
		assertThrows(IllegalArgumentException.class, () -> service.createPerson(person),
				() -> "Empty e-mail should have cause IllegalArgumentException");

	}

	@Test
	@DisplayName("When Create a Person with null email throw message exception")
	void testCreatePerson_WithNullEmail_shouIdThrowMessageException() {
		// Given
		person.setEmail(null);
		String expected = "The person email is null or empty";
		// Arrange
		// Then
		IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
				() -> service.createPerson(person));

		assertEquals(actual.getMessage(), expected, () -> "Error Message is not expected");

	}

}
