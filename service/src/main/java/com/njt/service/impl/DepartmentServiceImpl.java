package com.njt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njt.repo.DepartmentRepository;
import com.njt.repo.entity.Department;
import com.njt.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepo;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository theDepartmentRepo) {
	departmentRepo = theDepartmentRepo;
    }

    @Override
    public List<Department> findAll() {
	return departmentRepo.findAll();
    }

    @Override
    public Department findById(int theId) {
	Optional<Department> result = departmentRepo.findById(theId);

	Department department = null;

	if (result.isPresent()) {
	    return result.get();
	} else {
	    throw new RuntimeException("Could not find department with id: " + theId);
	}
    }

    @Override
    public void save(Department theDepartment) {
	departmentRepo.save(theDepartment);
    }

    @Override
    public void deleteById(int theId) {
	departmentRepo.deleteById(theId);
    }

}
