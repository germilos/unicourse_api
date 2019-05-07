package com.njt.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.njt.repo.entity.StudyProgram;
import com.njt.service.StudyProgramService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudyProgramRestController {

	private StudyProgramService studyProgramService;

	@Autowired
	public StudyProgramRestController(StudyProgramService theStudyProgramService) {
		studyProgramService = theStudyProgramService;
	}

	@GetMapping("/studyprograms")
	public List<StudyProgram> findAll() {
		return studyProgramService.findAll();
	}

	@GetMapping("/studyprograms/{studyProgramId}")
	public StudyProgram getStudyProgram(@PathVariable int studyProgramId) {
		return studyProgramService.findById(studyProgramId);
	}
}
