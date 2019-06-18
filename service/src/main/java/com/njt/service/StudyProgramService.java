package com.njt.service;

import java.util.List;

import com.njt.repo.entity.StudyProgram;

public interface StudyProgramService
{

	public List<StudyProgram> findAll();

	public StudyProgram findById(int theId);

	public void save(StudyProgram theStudyProgram);

	public void deleteById(int theId);
}
