package com.njt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.njt.repo.entity.Department;

@CrossOrigin(origins = "http://localhost:4200")
public interface DepartmentRepository extends JpaRepository<Department, Integer>
{

}
