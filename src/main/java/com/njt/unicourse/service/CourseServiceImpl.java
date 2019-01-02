package com.njt.unicourse.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njt.unicourse.dao.CourseDAO;
import com.njt.unicourse.entity.Course;


@Service
public class CourseServiceImpl implements CourseService {

		private CourseDAO courseDAO;

		@Autowired
		public CourseServiceImpl(CourseDAO theCourseDAO) {
				courseDAO = theCourseDAO;
		}

		@Override
		@Transactional
		public List<Course> findAll() {
				return courseDAO.findAll();
		}

		@Override
		@Transactional
		public Course findById(int theId) {
				// TODO Auto-generated method stub
				return courseDAO.findById(theId);
		}

		@Override
		@Transactional
		public void save(Course theCourse) {
				courseDAO.save(theCourse);
		}

		@Override
		@Transactional
		public void deleteById(int theId) {
				courseDAO.deleteById(theId);
		}
}
