package com.njt.unicourse.service;

import java.util.List;

import com.njt.unicourse.entity.StudyProgram;

public interface StudyProgramService {

    public List<StudyProgram> findAll();

    public StudyProgram findById(int theId);

    public void save(StudyProgram theStudyProgram);

    public void deleteById(int theId);
}
