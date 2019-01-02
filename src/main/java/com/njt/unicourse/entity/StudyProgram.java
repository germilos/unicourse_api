package com.njt.unicourse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "study_program")
public class StudyProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "accreditation_year")
    private String accreditationYear;

    public StudyProgram() {

    }

    public StudyProgram(String name, String accreditationYear) {
	this.name = name;
	this.accreditationYear = accreditationYear;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getAccreditationYear() {
	return accreditationYear;
    }

    public void setAccreditationYear(String accreditationYear) {
	this.accreditationYear = accreditationYear;
    }

    @Override
    public String toString() {
	return "StudyProgram [id=" + id + ", name=" + name + ", accreditationYear=" + accreditationYear + "]";
    }
}
