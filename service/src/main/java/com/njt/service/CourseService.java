package com.njt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.njt.repo.entity.Course;
import com.njt.repo.entity.Lecturer;

public interface CourseService {

	public long count();

	public List<Course> findAll();

	public Page<Course> findAll(int page, int size, String orderBy, String direction);

	public Page<Course> findByNameContaining(String name, int page, int size, String orderBy, String direction);

	public Page<Course> findByDepartmentIds(List<Integer> departmentIds, int page, int size, String orderBy,
			String direction);

	public Page<Course> findByNameContainingAndDepartmentIds(String name, List<Integer> departmentIds, int page,
			int size, String orderBy, String direction);

	public Course findById(int theId);

	public Course save(Course theCourse);

	public void deleteById(int theId);
}
