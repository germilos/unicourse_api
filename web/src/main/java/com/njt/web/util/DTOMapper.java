package com.njt.web.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import com.njt.repo.dto.CourseListElementDTO;
import com.njt.repo.entity.Course;

public class DTOMapper {

    private static  ModelMapper modelMapper;
    private static DTOMapper instance;
    
    private DTOMapper() {
    	this.modelMapper = new ModelMapper();
    }
    
    public static synchronized DTOMapper getInstance() {
    	return instance == null ? new DTOMapper() : instance;
    }

	public List<CourseListElementDTO> convertCoursePageToDTO(Page<Course> coursePage) {
		return coursePage.stream().map(course -> modelMapper.map(course, CourseListElementDTO.class))
				.collect(Collectors.toList());
	}
	
	public List<CourseListElementDTO> convertCoursesToDTO(List<Course> courses ) {
		return courses.stream().map(course -> modelMapper.map(course, CourseListElementDTO.class))
				.collect(Collectors.toList());
	}
}
