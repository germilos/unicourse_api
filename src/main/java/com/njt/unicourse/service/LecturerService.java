package com.njt.unicourse.service;

import java.util.List;

import com.njt.unicourse.entity.Lecturer;


public interface LecturerService {
		public List<Lecturer> findAll();

		public Lecturer findById(int theId);

		public void save(Lecturer theLecturer);

		public void deleteById(int theId);
}
