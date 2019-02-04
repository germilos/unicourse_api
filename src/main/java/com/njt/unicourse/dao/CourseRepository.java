package com.njt.unicourse.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.njt.unicourse.entity.Course;

//@CrossOrigin(origins = "http://localhost:4200")
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
