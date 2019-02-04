package com.njt.unicourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njt.unicourse.dao.CourseRepository;
import com.njt.unicourse.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepo;

    @Autowired
    public CourseServiceImpl(CourseRepository theCourseRepository) {
	courseRepo = theCourseRepository;
    }

    @Override
    public List<Course> findAll() {
	return courseRepo.findAll();
    }

    @Override
    public Course findById(int theId) {
	Optional<Course> result = courseRepo.findById(theId);

	Course course = null;

	if (result.isPresent()) {
	    return result.get();
	} else {
	    throw new RuntimeException("Could not find course with id: " + theId);
	}
    }

    @Override
    public Course save(Course theCourse) {
	return courseRepo.save(theCourse);
    }

    @Override
    public void deleteById(int theId) {
	courseRepo.deleteById(theId);
    }

}
