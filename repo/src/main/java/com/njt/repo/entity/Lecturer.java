package com.njt.repo.entity;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "department_id")
    protected Department department;

    @ManyToMany
    @JoinTable(name = "course_lecturer", joinColumns = @JoinColumn(name = "lecturer_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
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
}