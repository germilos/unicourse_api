package com.njt.unicourse.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.njt.unicourse.entity.Lecturer;


public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

}
