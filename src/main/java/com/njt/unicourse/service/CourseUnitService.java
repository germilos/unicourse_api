package com.njt.unicourse.service;

import com.njt.unicourse.entity.Course;
import com.njt.unicourse.entity.CourseUnit;

public interface CourseUnitService {

    public Course findById(int theId);

    public Course save(CourseUnit theCourseUnit);

    public void deleteById(int theId);
}
