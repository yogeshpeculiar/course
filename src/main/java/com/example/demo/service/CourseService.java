package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.*;
import com.example.demo.model.Course;
import com.example.demo.model.CourseSubscribedVideo;


@Service
public class CourseService  {
	 @Autowired 
	 CourseDAO courseDAO;
	 @Transactional
	public void addCourse(Course course) {
		courseDAO.insert(course);
	}
	 @Transactional
	 public List<Course> view() {
		 return courseDAO.view();
	 }
	 
	 @Transactional
	 public Course update(Course c) {
		 return courseDAO.update(c);
	 }
	 @Transactional
	 public boolean isExists(int id) {
		 return courseDAO.isCourseIdExists(id);
	 }
	 @Transactional
	 public String delete(int id) {
		  return courseDAO.delete(id);
	 }
}
