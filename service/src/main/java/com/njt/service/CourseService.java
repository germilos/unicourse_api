package com.njt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.njt.repo.dto.CourseListElementDTO;
import com.njt.repo.entity.Course;
import com.njt.repo.entity.Lecturer;

public interface CourseService
{

	public long count();

	public List<Course> findAll();

	public Page<Course> findAll(Pageable pageable);

	public Page<Course> findByNameContaining(String name, Pageable pageable);

	public Page<Course> findByDepartmentIds(List<Integer> departmentIds, Pageable pageable);

	public Page<Course> findByNameContainingAndDepartmentIds(String name, List<Integer> departmentIds,
			Pageable pageable);

	public Course findById(int theId);

	public Course save(Course theCourse);

	public Course update(Course theCourse);

	public void deleteById(int theId);
}
