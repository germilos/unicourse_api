package com.njt.service;

import com.njt.repo.entity.Course;
import com.njt.repo.entity.CourseUnit;

public interface CourseUnitService {

    public Course findById(int theId);

    public Course save(CourseUnit theCourseUnit);

    public void deleteById(int theId);
}
