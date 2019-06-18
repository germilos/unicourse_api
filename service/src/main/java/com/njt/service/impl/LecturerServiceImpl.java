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
@Transactional(readOnly = true)
public class LecturerServiceImpl implements LecturerService
{

	private LecturerRepository lecturerRepo;

	@Autowired
	public LecturerServiceImpl(LecturerRepository theLecturerRepo)
	{
		lecturerRepo = theLecturerRepo;
	}

	@Override
	public long getCount()
	{
		return lecturerRepo.count();
	}

	@Override
	public List<Lecturer> findAll()
	{
		List<Lecturer> lecturers = null;
		try
		{
			lecturers = lecturerRepo.findAll();
			if (lecturers == null)
				throw new RuntimeException("Error retrieving lecturers!");
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return lecturers;
	}

	@Override
	public Page<Lecturer> findAll(Pageable pageable)
	{
		Page<Lecturer> lecturers = null;
		try
		{
			lecturers = lecturerRepo.findAll(pageable);
			if (lecturers == null)
				throw new RuntimeException("Error retrieving lecturers!");
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return lecturers;
	}

	@Override
	public Page<Lecturer> findByNameSurnameContaining(String name, Pageable pageable)
	{
		Page<Lecturer> lecturers = null;
		try
		{
			lecturers = lecturerRepo.findByNameSurnameContaining(name, pageable);
			if (lecturers == null)
				throw new RuntimeException("Error retrieving lecturers!");
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return lecturers;
	}

	@Override
	public Page<Lecturer> findByDepartmentIds(List<Integer> departmentIds, Pageable pageable)
	{
		Page<Lecturer> lecturers = null;
		try
		{
			lecturers = lecturerRepo.findByDepartmentIdIn(departmentIds, pageable);
			if (lecturers == null)
				throw new RuntimeException("Error retrieving lecturers!");
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return lecturers;
	}

	@Override
	public Page<Lecturer> findByNameContainingAndDepartmentIds(String name, List<Integer> departmentIds,
			Pageable pageable)
	{
		Page<Lecturer> lecturers = null;
		try
		{
			lecturers = lecturerRepo.findByNameSurnameContainingAndDepartmentIdIn(name, departmentIds, pageable);
			if (lecturers == null)
				throw new RuntimeException("Error retrieving lecturers!");
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return lecturers;
	}

	@Override
	public Lecturer findById(int theId)
	{
		Optional<Lecturer> result = null;
		try
		{
			result = lecturerRepo.findById(theId);
			if (!result.isPresent())
			{
				throw new RuntimeException("Could not find lecturer with id: " + theId);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return result.get();
	}

	@Override
	@Transactional
	public Lecturer save(Lecturer theLecturer)
	{
		Lecturer lecturer = null;
		try
		{
			lecturer = lecturerRepo.save(theLecturer);
			if (lecturer == null)
				throw new RuntimeException("Error saving lecturer!");
		}
		catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return lecturer;
	}

	@Override
	@Transactional
	public void deleteById(int theId)
	{
		try
		{
			lecturerRepo.deleteById(theId);
		}
		catch (Exception e)
		{
			throw new RuntimeException("Error deleting lecturer with id: " + theId);
		}
	}

	private Sort getSort(String direction, String orderBy)
	{
		return direction.equals("ASC") ? new Sort(Sort.Direction.ASC, orderBy) : new Sort(Sort.Direction.DESC, orderBy);
	}
}
