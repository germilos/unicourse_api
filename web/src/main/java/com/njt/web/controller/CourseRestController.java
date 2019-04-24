package com.njt.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.njt.repo.dto.CourseListElementDTO;
import com.njt.repo.entity.Course;
import com.njt.service.CourseService;
import com.njt.service.exception.NotFoundException;
import com.njt.web.util.DTOMapper;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseRestController {

	private CourseService courseService;

	@Autowired
	public CourseRestController(CourseService theCourseService) {
		courseService = theCourseService;
	}

	@GetMapping("/courses/count")
	public long getCourseCount() {
		return courseService.count();
	}

	@GetMapping("/courses")
	public List<CourseListElementDTO> findAll() {
		List<Course> courses = courseService.findAll();
		return DTOMapper.getInstance().convertCoursesToDTO(courses);
	}

	@GetMapping(value = "courses/get", params = { "page", "size", "orderBy", "direction" })
	public Page<CourseListElementDTO> findPaginated(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("orderBy") String orderBy, @RequestParam("direction") String direction) {
		Pageable pageable = PageRequest.of(page, size, getSort(direction, orderBy));
		Page<Course> coursePage = courseService.findAll(pageable);
		return new PageImpl<CourseListElementDTO>(DTOMapper.getInstance().convertCoursePageToDTO(coursePage), pageable,
				coursePage.getTotalElements());
	}

	@GetMapping(value = "courses/get", params = { "name", "page", "size", "orderBy", "direction" })
	public Page<CourseListElementDTO> findByNameSurnameContaining(@RequestParam("name") String name,
			@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("orderBy") String orderBy,
			@RequestParam("direction") String direction) {
		Pageable pageable = PageRequest.of(page, size, getSort(direction, orderBy));
		Page<Course> coursePage = courseService.findByNameContaining(name, pageable);
		return new PageImpl<CourseListElementDTO>(DTOMapper.getInstance().convertCoursePageToDTO(coursePage), pageable,
				coursePage.getTotalElements());
	}

	@GetMapping(value = "courses/get", params = { "departmentId", "page", "pageSize", "orderBy", "direction" })
	public Page<CourseListElementDTO> findByDepartmentIds(@RequestParam("departmentId") List<Integer> departmentId,
			@RequestParam("page") int page, @RequestParam("pageSize") int size, @RequestParam("orderBy") String orderBy,
			@RequestParam("direction") String direction) {
		Pageable pageable = PageRequest.of(page, size, getSort(direction, orderBy));
		Page<Course> coursePage = courseService.findByDepartmentIds(departmentId, pageable);
		return new PageImpl<CourseListElementDTO>(DTOMapper.getInstance().convertCoursePageToDTO(coursePage), pageable,
				coursePage.getTotalElements());
	}

	@GetMapping(value = "courses/get", params = { "name", "departmentId", "page", "pageSize", "orderBy", "direction" })
	public Page<CourseListElementDTO> findByNameSurnameAndDepartmentIds(@RequestParam("name") String name,
			@RequestParam("departmentId") List<Integer> departmentId, @RequestParam("page") int page,
			@RequestParam("pageSize") int size, @RequestParam("orderBy") String orderBy,
			@RequestParam("direction") String direction) {
		Pageable pageable = PageRequest.of(page, size, getSort(direction, orderBy));
		Page<Course> coursePage = courseService.findByNameContainingAndDepartmentIds(name, departmentId, pageable);
		return new PageImpl<CourseListElementDTO>(DTOMapper.getInstance().convertCoursePageToDTO(coursePage), pageable,
				coursePage.getTotalElements());
	}

	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable int courseId) {
		return courseService.findById(courseId);
	}

	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course theCourse) {
		return courseService.save(theCourse);
	}

	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course theCourse) {
		return courseService.save(theCourse);
	}

	@DeleteMapping("/courses/{courseId}")
	public void deleteCourse(@PathVariable int courseId) {
		courseService.deleteById(courseId);
	}

	private Sort getSort(String direction, String orderBy) {
		return direction.equals("ASC") ? new Sort(Sort.Direction.ASC, orderBy) : new Sort(Sort.Direction.DESC, orderBy);
	}
}
