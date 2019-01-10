package com.njt.unicourse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.njt.unicourse.entity.Lecturer;

@CrossOrigin(origins = "http://localhost:4200")
public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

}
