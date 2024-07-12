package io.bgeles.persons;

import io.bgeles.persons.model.Person;

public class PersonService implements IPersonService {

	public PersonService() {
	}

	@Override
	public Person createPerson(Person person) {
		if (person.getEmail() == null || person.getEmail().isBlank())
			throw new IllegalArgumentException("The person email is null or empty");
		person.setId(Long.valueOf((long) Math.random()));
		return person;
	}

}
