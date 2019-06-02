package com.njt.repo.dto;

import java.util.List;
import java.util.Set;

public class SignUpFormDTO
{
	private String name;

	private String username;

	private String email;

	private List<String> role;

	private String password;

	public SignUpFormDTO()
	{
		// TODO Auto-generated constructor stub
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public List<String> getRole()
	{
		return this.role;
	}

	public void setRole(List<String> role)
	{
		this.role = role;
	}
}
