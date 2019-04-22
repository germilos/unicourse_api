package com.njt.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.njt.repo.entity.Lecturer;


@CrossOrigin(origins = "http://localhost:4200")
public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

	Page<Lecturer> findByNameSurnameContaining(String nameSurname, Pageable pageable);
	Page<Lecturer> findByDepartmentIdIn(List<Integer> departmentIds, Pageable pageable);
	Page<Lecturer> findByNameSurnameContainingAndDepartmentIdIn(String name, List<Integer> departmentIds, Pageable pageable);
}

