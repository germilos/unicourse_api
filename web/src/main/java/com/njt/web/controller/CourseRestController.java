package com.njt.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.njt.repo.dto.CourseListElementDTO;
import com.njt.repo.entity.Course;
import com.njt.service.CourseService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseRestController {

	private CourseService courseService;
	private ModelMapper modelMapper;

	@Autowired
	public CourseRestController(CourseService theCourseService, ModelMapper theModelMapper) {
		courseService = theCourseService;
		modelMapper = theModelMapper;
	}

	@GetMapping("/courses/count")
	public long getCourseCount() {
		return courseService.count();
	}

	@GetMapping("/courses")
	public List<CourseListElementDTO> findAll() {
		List<Course> courses = courseService.findAll();
		return courses.stream().map(course -> modelMapper.map(course, CourseListElementDTO.class))
				.collect(Collectors.toList());
	}

	@GetMapping(value = "courses/get", params = { "page", "size", "orderBy", "direction" })
	public Page<Course> findPaginated(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("orderBy") String orderBy, @RequestParam("direction") String direction) {
		return courseService.findAll(page, size, orderBy, direction);
	}

	@GetMapping(value = "courses/get", params = { "name", "page", "size", "orderBy", "direction" })
	public Page<Course> findByNameSurnameContaining(@RequestParam("name") String name, @RequestParam("page") int page,
			@RequestParam("size") int size, @RequestParam("orderBy") String orderBy,
			@RequestParam("direction") String direction) {
		return courseService.findByNameContaining(name, page, size, orderBy, direction);
	}

	@GetMapping(value = "courses/get", params = { "departmentId", "page", "pageSize", "orderBy", "direction" })
	public Page<Course> findByDepartmentIds(@RequestParam("departmentId") List<Integer> departmentId,
			@RequestParam("page") int page, @RequestParam("pageSize") int size, @RequestParam("orderBy") String orderBy,
			@RequestParam("direction") String direction) {
		System.out.println("HERE");
		return courseService.findByDepartmentIds(departmentId, page, size, orderBy, direction);
	}

	@GetMapping(value = "courses/get", params = { "name", "departmentId", "page", "pageSize", "orderBy", "direction" })
	public Page<Course> findByNameSurnameAndDepartmentIds(@RequestParam("name") String name,
			@RequestParam("departmentId") List<Integer> departmentId, @RequestParam("page") int page,
			@RequestParam("pageSize") int size, @RequestParam("orderBy") String orderBy,
			@RequestParam("direction") String direction) {
		System.out.println("URL: " + "name=" + name + "departmentId=" + departmentId.get(0) + "page=" + page);
		return courseService.findByNameContainingAndDepartmentIds(name, departmentId, page, size, orderBy, direction);
	}

	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable int courseId) {
		return courseService.findById(courseId);
	}

	@PostMapping("/courses")
	public void addCourse(@RequestBody Course theCourse) {
//	theCourse.setId(0);

		Course savedCourse = courseService.save(theCourse);
	}

	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course theCourse) {

		courseService.save(theCourse);

		return theCourse;
	}

	@DeleteMapping("/courses/{courseId}")
	public String deleteCourse(@PathVariable int courseId) {

		Course theCourse = courseService.findById(courseId);
		if (theCourse == null) {
			throw new RuntimeException("Course with id: " + courseId + " not found!");
		}

		courseService.deleteById(courseId);

		return "Deleted course with id: " + courseId;
	}
}
