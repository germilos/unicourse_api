package com.njt.unicourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.njt.unicourse.entity.Lecturer;
import com.njt.unicourse.service.LecturerService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LecturerRestController {
    private LecturerService lecturerService;

    @Autowired
    public LecturerRestController(LecturerService theLecturerService) {
	lecturerService = theLecturerService;
    }

    @GetMapping("/lecturers")
    public List<Lecturer> findAll() {
	return lecturerService.findAll();
    }

    @GetMapping("/lecturers/{lecturerId}")
    public Lecturer getLecturer(@PathVariable int lecturerId) {
	return lecturerService.findById(lecturerId);
    }

    @PostMapping("/lecturers")
    public Lecturer addLecturer(@RequestBody Lecturer theLecturer) {

	theLecturer.setId(0);

	lecturerService.save(theLecturer);

	return theLecturer;
    }

    @PutMapping("/lecturers")
    public Lecturer updateLecturer(@RequestBody Lecturer theLecturer) {

	lecturerService.save(theLecturer);

	return theLecturer;
    }

    @DeleteMapping("/lecturers/{lecturerId}")
    public String deleteLecturer(@PathVariable int lecturerId) {

	Lecturer theLecturer = lecturerService.findById(lecturerId);
	if (theLecturer == null) {
	    throw new RuntimeException("Lecturer with id: " + lecturerId + " not found!");
	}

	lecturerService.deleteById(lecturerId);

	return "Deleted Lecturer with id: " + lecturerId;
    }
}
