package com.njt.unicourse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.njt.unicourse.entity.Department;

@CrossOrigin(origins = "http://localhost:4200")
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
