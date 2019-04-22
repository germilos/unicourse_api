package com.njt.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.njt.repo.entity.Lecturer;
import com.njt.service.LecturerService;


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
    
    @GetMapping("/lecturers/count")
    public long getCount() {
    	return lecturerService.getCount();
    }
    
    @GetMapping(value = "lecturers/get", params = {"page", "size", "orderBy", "direction"})
    public Page<Lecturer> findPaginated(@RequestParam("page") int page, @RequestParam("size") int size,
    	    @RequestParam("orderBy") String orderBy, @RequestParam("direction") String direction) {
    	return lecturerService.findAll(page, size, orderBy, direction);
    }

    @GetMapping(value = "lecturers/get", params = {"name", "page", "size", "orderBy", "direction"})
    public Page<Lecturer> findByNameSurnameContaining(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size,
    	    @RequestParam("orderBy") String orderBy, @RequestParam("direction") String direction) {
    	return lecturerService.findByNameSurnameContaining(name, page, size, orderBy, direction);
    }
    
    @GetMapping(value = "lecturers/get", params = {"departmentId", "page", "pageSize", "orderBy", "direction"})
    public Page<Lecturer> findByDepartmentIds(@RequestParam("departmentId") List<Integer> departmentId, @RequestParam("page") int page, @RequestParam("pageSize") int size,
    	    @RequestParam("orderBy") String orderBy, @RequestParam("direction") String direction) {
    	System.out.println("HERE");
    	return lecturerService.findByDepartmentIds(departmentId, page, size, orderBy, direction);
    }
    
    @GetMapping(value = "lecturers/get", params = {"name", "departmentId", "page", "pageSize", "orderBy", "direction"})
    public Page<Lecturer> findByNameSurnameAndDepartmentIds(@RequestParam("name") String name, @RequestParam("departmentId") List<Integer> departmentId, @RequestParam("page") int page, @RequestParam("pageSize") int size,
    	    @RequestParam("orderBy") String orderBy, @RequestParam("direction") String direction) {
    	System.out.println("URL: " + "name=" + name + "departmentId=" + departmentId.get(0) + "page=" + page);
    	return lecturerService.findByNameContainingAndDepartmentIds(name, departmentId, page, size, orderBy, direction);
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
