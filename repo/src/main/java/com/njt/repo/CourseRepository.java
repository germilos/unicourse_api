package com.njt.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.njt.repo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	Page<Course> findByNameContaining(String name, Pageable pageable);
	Page<Course> findByDepartmentIdIn(List<Integer> departmentIds, Pageable pageable);
	Page<Course> findByNameContainingAndDepartmentIdIn(String name, List<Integer> departmentIds, Pageable pageable);
} 
