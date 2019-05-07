package com.njt.repo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Table(name = "lecturer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Professor.class, name = "P"), @Type(value = Assistant.class, name = "A") })
public abstract class Lecturer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	@Column(name = "name_surname")
	protected String nameSurname;

	@Column(name = "study_field")
	protected String studyField;

	@Column(name = "type", insertable = false, updatable = false)
	protected char type;

	@ManyToOne
	@JoinColumn(name = "department_id")
	protected Department department;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "course_lecturer", joinColumns = @JoinColumn(name = "lecturer_id"),
		inverseJoinColumns = @JoinColumn(name = "course_id"))
	@JsonBackReference
	private List<Course> courses;

	public Lecturer() {
	}

	public Lecturer(String nameSurname, String studyField, Department department) {
		this.nameSurname = nameSurname;
		this.studyField = studyField;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameSurname() {
		return nameSurname;
	}

	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	public String getStudyField() {
		return studyField;
	}

	public void setStudyField(String studyField) {
		this.studyField = studyField;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Transient
	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Lecturer [id=" + id + ", nameSurname=" + nameSurname + ", studyField=" + studyField + ", type=" + type
				+ ", department=" + department + ", courses=" + courses + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lecturer other = (Lecturer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
