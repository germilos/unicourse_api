package com.njt.repo.dto;

import com.njt.repo.entity.Department;

public class CourseListElementDTO
{

	private int id;

	private String name;

	private String status;

	private int espb;

	private Department department;

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

}
