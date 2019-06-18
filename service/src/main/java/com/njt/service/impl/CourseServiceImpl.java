package com.njt.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.njt.repo.CourseUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njt.repo.CourseRepository;
import com.njt.repo.LecturerRepository;
import com.njt.repo.entity.Course;
import com.njt.repo.entity.CourseUnit;
import com.njt.repo.entity.Lecturer;
import com.njt.service.CourseService;
import com.njt.service.exception.NotFoundException;

@Service
@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService
{

	private CourseRepository courseRepo;
	private CourseUnitRepository courseUnitRepo;

	@Autowired
	public CourseServiceImpl(CourseRepository theCourseRepository, CourseUnitRepository theCourseUnitRepo)
	{
		courseRepo = theCourseRepository;
		courseUnitRepo = theCourseUnitRepo;
	}

	// TODO: Remove, unnecessary with Page
	@Override
	public long count()
	{
		return courseRepo.count();
	}

	@Override
	public List<Course> findAll()
	{
		List<Course> courses = null;
		try
		{
			courses = courseRepo.findAll();
			if (courses == null)
			{
				throw new RuntimeException("Error retrieving courses!");
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return courses;
	}

	@Override
	public Page<Course> findAll(Pageable pageable)
	{
		Page<Course> coursesPage = null;
		try
		{
			coursesPage = courseRepo.findAll(pageable);
			if (coursesPage == null)
			{
				throw new RuntimeException("Error retrieving courses!");
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return coursesPage;
	}

	@Override
	public Page<Course> findByNameContaining(String name, Pageable pageable)
	{
		Page<Course> coursesPage = null;
		try
		{
			coursesPage = courseRepo.findByNameContaining(name, pageable);
			if (coursesPage == null)
			{
				throw new RuntimeException("Error retrieving courses!");
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return coursesPage;
	}

	@Override
	public Page<Course> findByDepartmentIds(List<Integer> departmentIds, Pageable pageable)
	{
		Page<Course> coursesPage = null;
		try
		{
			coursesPage = courseRepo.findByDepartmentIdIn(departmentIds, pageable);
			if (coursesPage == null)
			{
				throw new RuntimeException("Error retrieving courses!");
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return coursesPage;
	}

	@Override
	public Page<Course> findByNameContainingAndDepartmentIds(String name, List<Integer> departmentIds,
			Pageable pageable)
	{
		Page<Course> coursesPage = null;
		try
		{
			coursesPage = courseRepo.findByNameContainingAndDepartmentIdIn(name, departmentIds, pageable);
			if (coursesPage == null)
			{
				throw new RuntimeException("Error retrieving courses!");
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return coursesPage;
	}

	@Override
	public Course findById(int theId)
	{
		Optional<Course> result = null;
		try
		{
			result = courseRepo.findById(theId);
			if (!result.isPresent())
			{
				throw new RuntimeException("Could not find course with id: " + theId);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return result.get();
	}

	@Override
	@Transactional
	public Course save(Course theCourse)
	{
		Course savedCourse = null;
		try
		{
			List<CourseUnit> courseUnits = theCourse.getCourseUnits();
			theCourse.setCourseUnits(null);

			savedCourse = courseRepo.save(theCourse);
			for (CourseUnit courseUnit : courseUnits)
			{
				theCourse.addCourseUnit(courseUnit);
			}
			if (savedCourse == null)
			{
				throw new RuntimeException("Error saving course!");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return savedCourse;
	}

	@Override
	@Transactional
	public Course update(Course theCourse)
	{
		Optional<Course> courseOptional = null;
		Course courseToUpdate = null;
		try
		{
			courseOptional = courseRepo.findById(theCourse.getId());
			if (!courseOptional.isPresent())
			{
				throw new RuntimeException("Error updating course!");
			}
			courseToUpdate = courseOptional.get();
			courseToUpdate.clearCourseUnits();

			courseToUpdate.setName(theCourse.getName());
			courseToUpdate.setEspb(theCourse.getEspb());
			courseToUpdate.setDepartment(theCourse.getDepartment());
			courseToUpdate.setGoal(theCourse.getGoal());
			courseToUpdate.setStatus(theCourse.getStatus());
			courseToUpdate.setStudyProgram(theCourse.getStudyProgram());
			courseToUpdate.setLecturers(theCourse.getLecturers());

			for (CourseUnit courseUnit : theCourse.getCourseUnits())
			{
				courseToUpdate.addCourseUnit(courseUnit);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return courseToUpdate;
	}

	@Override
	@Transactional
	public void deleteById(int theId)
	{
		try
		{
			courseRepo.deleteById(theId);
		}
		catch (Exception e)
		{
			throw new RuntimeException("An error has occured while deleting the Course!");
		}
	}
}
