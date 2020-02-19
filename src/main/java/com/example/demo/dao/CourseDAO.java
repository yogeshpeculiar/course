package com.example.demo.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Course;

@Repository
public interface CourseDAO  {
public void insert(Course c);
public List<Course> view();
public Course update(Course c);
public boolean isCourseIdExists(int id);
public String delete(int id);

}
