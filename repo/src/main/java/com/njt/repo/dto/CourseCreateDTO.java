package com.njt.repo.dto;

import java.util.ArrayList;
import java.util.List;

import com.njt.repo.entity.CourseUnit;
import com.njt.repo.entity.Department;
import com.njt.repo.entity.Lecturer;
import com.njt.repo.entity.StudyProgram;

public class CourseCreateDTO
{

	private String name;

	private String goal;

	private String status;

	private int espb;

	private Department department;

	private StudyProgram studyProgram;

	private List<CourseUnit> courseUnits;

	private List<Lecturer> lecturers;

	public CourseCreateDTO()
	{

	}

	public CourseCreateDTO(String name, String goal, String status, int espb, Department department,
			StudyProgram studyProgram, List<CourseUnit> courseUnits)
	{
		this.name = name;
		this.goal = goal;
		this.status = status;
		this.espb = espb;
		this.department = department;
		this.studyProgram = studyProgram;
		this.courseUnits = courseUnits;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getGoal()
	{
		return goal;
	}

	public void setGoal(String goal)
	{
		this.goal = goal;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public int getEspb()
	{
		return espb;
	}

	public void setEspb(int espb)
	{
		this.espb = espb;
	}

	public Department getDepartment()
	{
		return department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}

	public StudyProgram getStudyProgram()
	{
		return studyProgram;
	}

	public void setStudyProgram(StudyProgram studyProgram)
	{
		this.studyProgram = studyProgram;
	}

	public List<CourseUnit> getCourseUnits()
	{
		return courseUnits;
	}

	public void setCourseUnits(List<CourseUnit> courseUnits)
	{
		this.courseUnits = courseUnits;
	}

	public List<Lecturer> getLecturers()
	{
		return lecturers;
	}

	public void setLecturers(List<Lecturer> lecturers)
	{
		this.lecturers = lecturers;
	}

	public void addCourseUnit(CourseUnit newUnit)
	{
		if (courseUnits == null)
		{
			courseUnits = new ArrayList<CourseUnit>();
		}

		courseUnits.add(newUnit);
	}

	@Override
	public String toString()
	{
		return "Course [name=" + name + ", goal=" + goal + ", status=" + status + ", espb=" + espb + ", courseUnits="
				+ courseUnits + "]" + "department = " + department;
	}
}
