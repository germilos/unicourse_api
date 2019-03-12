package com.njt.unicourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.njt.unicourse.dao.CourseRepository;
import com.njt.unicourse.dao.CourseUnitRepository;
import com.njt.unicourse.entity.Course;
import com.njt.unicourse.entity.CourseUnit;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepo;
    private CourseUnitRepository courseUnitRepo;

    @Autowired
    public CourseServiceImpl(CourseRepository theCourseRepository, CourseUnitRepository theCourseUnitRepository) {
	courseRepo = theCourseRepository;
	courseUnitRepo = theCourseUnitRepository;
    }

    @Override
    public List<Course> findAll() {
	return courseRepo.findAll();
    }
    
    @Override
    public Page<Course> findAll(int page, int size, String orderBy, String direction) {
	Sort sort = null;
	if (direction.equals("ASC")) {
	    sort = new Sort(Sort.Direction.ASC, orderBy);
	} else if (direction.equals("DESC")) {
	    sort = new Sort(Sort.Direction.DESC, orderBy);
	}
	
	Pageable pageable = PageRequest.of(page, size, sort);
	return courseRepo.findAll(pageable);
    }

    @Override
    public Course findById(int theId) {
	Optional<Course> result = courseRepo.findById(theId);

	Course course = null;

	if (result.isPresent()) {
	    course = result.get();
	    course.getCourseUnits();
	    return course;
	} else {
	    throw new RuntimeException("Could not find course with id: " + theId);
	}
    }

    @Override
    public Course save(Course theCourse) {
	/*
	 * Get course units from passed Course - they do not have courseId value (POST
	 * method)
	 */
	List<CourseUnit> courseUnits = theCourse.getCourseUnits();
	theCourse.setCourseUnits(null);

	// Save passed Course without course units
	Course savedCourse = courseRepo.save(theCourse);

	/*
	 * Iterate through course unit list, assigning saved Course to each and then
	 * saving each unit individually
	 */
	for (CourseUnit theCourseUnit : courseUnits) {
	    theCourseUnit.setCourse(savedCourse);
	    courseUnitRepo.save(theCourseUnit);
	}
	savedCourse.setCourseUnits(courseUnits);
	return savedCourse;
    }

    @Override
    public void deleteById(int theId) {
	courseRepo.deleteById(theId);
    }

}
