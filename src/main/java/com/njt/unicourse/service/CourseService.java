package com.njt.unicourse.service;

import java.util.List;

import com.njt.unicourse.entity.Course;

public interface CourseService {

    public List<Course> findAll();

    public Course findById(int theId);

    public void save(Course theCourse);

    public void deleteById(int theId);
}
