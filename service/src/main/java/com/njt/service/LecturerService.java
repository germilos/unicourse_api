package com.njt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.njt.repo.entity.Lecturer;

public interface LecturerService
{

	public long getCount();

	public List<Lecturer> findAll();

	public Page<Lecturer> findAll(Pageable pageable);

	public Page<Lecturer> findByNameSurnameContaining(String name, Pageable pageable);

	public Page<Lecturer> findByDepartmentIds(List<Integer> departmentIds, Pageable pageable);

	public Page<Lecturer> findByNameContainingAndDepartmentIds(String name, List<Integer> departmentIds,
			Pageable pageable);

	public Lecturer findById(int theId);

	public Lecturer save(Lecturer theLecturer);

	public void deleteById(int theId);
}
