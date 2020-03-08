package com.revature.coursems.service.impl;

import com.revature.coursems.domain.Course;
import com.revature.coursems.repository.CourseRepository;
import com.revature.coursems.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public void saveCourse(Course course)
    {
        courseRepository.saveCourse(course);
    }
}
