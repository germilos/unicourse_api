package com.njt.repo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.njt.repo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
