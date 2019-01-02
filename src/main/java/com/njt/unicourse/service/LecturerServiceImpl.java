package com.njt.unicourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njt.unicourse.dao.LecturerRepository;
import com.njt.unicourse.entity.Lecturer;

@Service
public class LecturerServiceImpl implements LecturerService {

    private LecturerRepository lecturerRepo;

    @Autowired
    public LecturerServiceImpl(LecturerRepository theLecturerRepo) {
	lecturerRepo = theLecturerRepo;
    }

    @Override
    public List<Lecturer> findAll() {
	return lecturerRepo.findAll();
    }

    @Override
    public Lecturer findById(int theId) {
	Optional<Lecturer> result = lecturerRepo.findById(theId);

	Lecturer lecturer = null;

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
}
