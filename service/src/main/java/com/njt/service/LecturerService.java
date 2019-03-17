package com.njt.service;

import java.util.List;

import com.njt.repo.entity.Lecturer;


public interface LecturerService {
    public List<Lecturer> findAll();

    public Lecturer findById(int theId);

    public void save(Lecturer theLecturer);

    public void deleteById(int theId);
}
