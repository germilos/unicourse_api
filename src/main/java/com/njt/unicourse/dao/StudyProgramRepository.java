package com.njt.unicourse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.njt.unicourse.entity.StudyProgram;

@CrossOrigin(origins = "http://localhost:4200")
public interface StudyProgramRepository extends JpaRepository<StudyProgram, Integer> {

}
