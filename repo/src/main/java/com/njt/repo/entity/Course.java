package com.njt.repo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "course")
public class Course
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "goal")
	private String goal;

	@Column(name = "status")
	private String status;

	@Column(name = "espb")
	private int espb;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "study_program_id")
	private StudyProgram studyProgram;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CourseUnit> courseUnits;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "course_lecturer", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "lecturer_id"))
	private List<Lecturer> lecturers;

	public Course()
	{
		this.courseUnits = new ArrayList<CourseUnit>();
		this.lecturers = new ArrayList<Lecturer>();
	}

	public Course(String name, String goal, String status, int espb, Department department, StudyProgram studyProgram,
			List<CourseUnit> courseUnits)
	{
		this.name = name;
		this.goal = goal;
		this.status = status;
		this.espb = espb;
		this.department = department;
		this.studyProgram = studyProgram;
		this.courseUnits = courseUnits;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
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
		newUnit.setCourse(this);
	}

	public void removeCourseUnit(CourseUnit courseUnit)
	{
		courseUnits.remove(courseUnit);
		courseUnit.setCourse(null);
	}

	public void clearCourseUnits()
	{
		for (CourseUnit courseUnit : courseUnits)
		{
			courseUnit.setCourse(null);
		}
		courseUnits.clear();
	}

	public void addLecturer(Lecturer lecturer)
	{
		if (lecturers == null)
			lecturers = new ArrayList<Lecturer>();
		lecturers.add(lecturer);
	}

	@Override
	public String toString()
	{
		return "Course [id=" + id + ", name=" + name + ", goal=" + goal + ", status=" + status + ", espb=" + espb
				+ ", courseUnits=" + courseUnits + "]" + "department = " + department + ", lecturers=" + lecturers;
	}
}
