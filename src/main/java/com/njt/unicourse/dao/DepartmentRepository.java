package com.njt.unicourse.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.njt.unicourse.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
