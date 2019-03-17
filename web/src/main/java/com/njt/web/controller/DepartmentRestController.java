package com.njt.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.njt.repo.entity.Department;
import com.njt.service.DepartmentService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentRestController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentRestController(DepartmentService theDepartmentService) {
	departmentService = theDepartmentService;
    }

    @GetMapping("/departments")
    public List<Department> findAll() {
	return departmentService.findAll();
    }

    @GetMapping("/departments/{departmentId}")
    public Department getDepartment(@PathVariable int departmentId) {
	return departmentService.findById(departmentId);
    }
}
