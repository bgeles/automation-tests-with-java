package io.bgeles.mockito.business;

import java.util.ArrayList;
import java.util.List;

import io.bgeles.mockito.services.CourseService;

//SUT - SYSTEM (METHOD) Under Test
public class CourseBusiness {

	// Course Service is a dependency
	private CourseService service;

	public CourseBusiness(CourseService service) {
		this.service = service;
	}

	public List<String> retrieveCourseRelatedToSpring(String student) {
		List<String> filteredCourses = new ArrayList<>();
		if ("Foo Bar".equals(student))
			return filteredCourses;
		List<String> allCourses = service.retrieveCourse(student);

		for (String course : allCourses) {
			if (course.contains("Spring")) {
				filteredCourses.add(course);
			}
		}
		return filteredCourses;

	}

	public void deleteCoursesNotRelatedToSpring(String student) {
		List<String> allCourses = service.retrieveCourse(student);
		for (String course : allCourses) {
			if (!course.contains("Spring")) {
				service.deleteCourse(course);
			}
		}
	}
}
