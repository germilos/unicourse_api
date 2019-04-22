package com.njt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njt.repo.LecturerRepository;
import com.njt.repo.entity.Lecturer;
import com.njt.service.LecturerService;

@Service
@Transactional
public class LecturerServiceImpl implements LecturerService {

	private LecturerRepository lecturerRepo;

	@Autowired
	public LecturerServiceImpl(LecturerRepository theLecturerRepo) {
		lecturerRepo = theLecturerRepo;
	}

	@Override
	public long getCount() {
		return lecturerRepo.count();
	}

	@Override
	public List<Lecturer> findAll() {
		return lecturerRepo.findAll();
	}

	@Override
	public Page<Lecturer> findAll(int page, int size, String orderBy, String direction) {
		Pageable pageable = PageRequest.of(page, size, getSort(direction, orderBy));
		return lecturerRepo.findAll(pageable);
	}

	@Override
	public Page<Lecturer> findByNameSurnameContaining(String name, int page, int size, String orderBy,
			String direction) {
		Pageable pageable = PageRequest.of(page, size, getSort(direction, orderBy));
		return lecturerRepo.findByNameSurnameContaining(name, pageable);
	}

	@Override
	public Page<Lecturer> findByDepartmentIds(List<Integer> departmentIds, int page, int size, String orderBy,
			String direction) {
		Pageable pageable = PageRequest.of(page, size, getSort(direction, orderBy));
		return lecturerRepo.findByDepartmentIdIn(departmentIds, pageable);
	}

	@Override
	public Page<Lecturer>  findByNameContainingAndDepartmentIds (String name, List<Integer> departmentIds, int page,
			int size, String orderBy, String direction) {
		Pageable pageable = PageRequest.of(page, size, getSort(direction, orderBy));
		return lecturerRepo.findByNameSurnameContainingAndDepartmentIdIn(name, departmentIds, pageable);
	}

	@Override
	public Lecturer findById(int theId) {
		Optional<Lecturer> result = lecturerRepo.findById(theId);
		
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("Could not find lecturer with id: " + theId);
		}
	}

	@Override
	public void save(Lecturer theLecturer) {
		lecturerRepo.save(theLecturer);
	}

	@Override
	public void deleteById(int theId) {
		lecturerRepo.deleteById(theId);
	}
	
	private Sort getSort(String direction, String orderBy) {
		return direction.equals("ASC") ? new Sort(Sort.Direction.ASC, orderBy) : new Sort(Sort.Direction.DESC, orderBy);
	}
}
