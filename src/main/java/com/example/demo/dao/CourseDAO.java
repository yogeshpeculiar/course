package com.example.demo.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Course;
import com.example.demo.model.CourseSubscribedVideo;

import DTO.updateDTO;
//@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface CourseDAO  {
public void insert(Course c);
public List<Course> view();
public Course update(Course c);
public boolean isCourseIdExists(int id);
public String delete(int id);
public Course findCourseByID(int id);

}
