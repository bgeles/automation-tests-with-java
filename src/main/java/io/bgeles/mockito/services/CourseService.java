package io.bgeles.mockito.services;

import java.util.List;

public interface CourseService {
	
	public List<String>  retrieveCourse(String student);
	public List<String> doSomething(String student);
	public void deleteCourse(String course);

}
