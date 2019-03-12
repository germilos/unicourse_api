package com.njt.unicourse.dao;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.njt.unicourse.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
