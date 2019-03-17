package com.njt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njt.repo.StudyProgramRepository;
import com.njt.repo.entity.StudyProgram;
import com.njt.service.StudyProgramService;

@Service
public class StudyProgramServiceImpl implements StudyProgramService {
    private StudyProgramRepository studyProgramRepo;

    @Autowired
    public StudyProgramServiceImpl(StudyProgramRepository theStudyProgramRepo) {
	studyProgramRepo = theStudyProgramRepo;
    }

    @Override
    public List<StudyProgram> findAll() {
	return studyProgramRepo.findAll();
    }

    @Override
    public StudyProgram findById(int theId) {
	Optional<StudyProgram> result = studyProgramRepo.findById(theId);

	StudyProgram lecturer = null;

	if (result.isPresent()) {
	    return result.get();
	} else {
	    throw new RuntimeException("Could not find study program with id: " + theId);
	}
    }

    @Override
    public void save(StudyProgram theStudyProgram) {
	studyProgramRepo.save(theStudyProgram);
    }

    @Override
    public void deleteById(int theId) {
	studyProgramRepo.deleteById(theId);
    }
}
