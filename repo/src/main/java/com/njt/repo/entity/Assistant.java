package com.njt.repo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "A")
public class Assistant extends Lecturer {

    @Column(name = "diploma")
    private String diploma;

    public Assistant() {
	super(null, null, null);
    }

    public Assistant(String nameSurname, String studyField, Department department, String diploma) {
	super(nameSurname, studyField, department);
	this.diploma = diploma;
    }

    public String getDiploma() {
	return diploma;
    }

    public void setDiploma(String diploma) {
	this.diploma = diploma;
    }
}
