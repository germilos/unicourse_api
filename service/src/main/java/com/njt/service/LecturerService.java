package com.njt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.njt.repo.entity.Lecturer;


public interface LecturerService {    
	
    public long getCount();
    
    public List<Lecturer> findAll();
    
    public Page<Lecturer> findAll(int page, int size, String orderBy, String direction);

    public Page<Lecturer> findByNameSurnameContaining(String name, int page, int size, String orderBy, String direction);
    
    public Page<Lecturer> findByDepartmentIds(List<Integer> departmentIds, int page, int size, String orderBy, String direction);
    
    public Page<Lecturer> findByNameContainingAndDepartmentIds(String name, List<Integer> departmentIds, int page, int size, String orderBy, String direction);
    
    public Lecturer findById(int theId);

    public void save(Lecturer theLecturer);

    public void deleteById(int theId);
}
