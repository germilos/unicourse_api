package com.njt.unicourse.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.njt.unicourse.entity.Course;

public interface CourseService {

    public long count();

    public List<Course> findAll();

    public Page<Course> findAll(int page, int size, String orderBy, String direction);

    public Course findById(int theId);

    public Course save(Course theCourse);

    public void deleteById(int theId);
}
