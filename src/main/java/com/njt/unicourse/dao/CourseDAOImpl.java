package com.njt.unicourse.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.njt.unicourse.entity.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {

    private EntityManager entityManager;

    @Autowired
    public CourseDAOImpl(EntityManager theEntityManager) {
	entityManager = theEntityManager;
    }

    @Override
    public List<Course> findAll() {

	Query theQuery = entityManager.createQuery("from Course");

	List<Course> courses = theQuery.getResultList();

	return courses;
    }

    @Override
    public Course findById(int theId) {

	Course course = entityManager.find(Course.class, theId);

	return course;
    }

    @Override
    public void save(Course theCourse) {

	Course dbCourse = entityManager.merge(theCourse);

	theCourse.setId(dbCourse.getId());
    }

    @Override
    public void deleteById(int theId) {
	Query theQuery = entityManager.createQuery("delete from Course where id=:courseId");

	theQuery.setParameter("courseId", theId);

	theQuery.executeUpdate();

    }
}
