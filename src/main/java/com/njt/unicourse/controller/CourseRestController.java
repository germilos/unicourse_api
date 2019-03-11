package com.njt.unicourse.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.njt.unicourse.entity.Course;
import com.njt.unicourse.entity.dto.CourseListElementDTO;
import com.njt.unicourse.service.CourseService;

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

    @GetMapping("/courses")
    public List<CourseListElementDTO> findAll() {
	List<Course> courses = courseService.findAll();
	return courses.stream().map(course -> modelMapper.map(course, CourseListElementDTO.class))
		.collect(Collectors.toList());
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
