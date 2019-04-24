package com.njt.repo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "P")
public class Professor extends Lecturer {

	@Column(name = "position")
	private String position;

	@Column(name = "research_number")
	private int researchNumber;

	public Professor() {
		super(null, null, null);
	}

	public Professor(String nameSurname, String studyField, Department department, String position,
			int researchNumber) {
		super(nameSurname, studyField, department);
		this.position = position;
		this.researchNumber = researchNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getResearchNumber() {
		return researchNumber;
	}

	public void setResearchNumber(int researchNumber) {
		this.researchNumber = researchNumber;
	}

	@Override
	public String toString() {
		return "Professor [position=" + position + ", researchNumber=" + researchNumber + ", id=" + id
				+ ", nameSurname=" + nameSurname + ", studyField=" + studyField + ", department=" + department + "]";
	}
}
