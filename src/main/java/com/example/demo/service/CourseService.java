package com.example.demo.service;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.DTO.insertDTO;
import com.example.demo.DTO.updateDTO;
import com.example.demo.dao.CourseDAO;
import com.example.demo.model.Course;

import lombok.extern.log4j.Log4j;
@CrossOrigin(origins = "http://localhost:4200")
@Service
@Log4j
public class CourseService  {
	 @Autowired 
	 CourseDAO courseDAO;
	 @Transactional
	public void addCourse(insertDTO insertDTOobj) {
		 
		 ModelMapper modelMapper = new ModelMapper();
		 Course courseObj = modelMapper.map(insertDTOobj, Course.class);
		 System.out.print(courseObj);
		 courseDAO.insert(courseObj);
	}
	 @Transactional
	 public List<Course> view() {
		 return courseDAO.view();
	 }
	 
	 @Transactional
	 public Course update(updateDTO c) {
		 ModelMapper modelMapper = new ModelMapper();
		  Course courseObj=courseDAO.findCourseByID(c.getId());
		 // System.out.println("our object issss"+String.valueOf(courseObj.getName()));
		 // BeanUtils.copyProperties(c, courseObj);
		  courseObj = modelMapper.map(c, Course.class);
		 System.out.println("our object issss"+String.valueOf(courseObj.getName())); 
		 if(isExists(courseObj.getId()))
			 System.out.println("given id is present in the db hence updation is possible...");
		 else
			 System.out.println("invalid id..");
		return courseDAO.update(courseObj);
	 }
	 @Transactional
	 public boolean isExists(int id) {
		 return courseDAO.isCourseIdExists(id);
	 }
	 @Transactional
	 public String delete(int id) {
		  return courseDAO.delete(id);
	 }
	 @Transactional
	 public String addImage(String filename) {
		 return courseDAO.addImage(filename);	 }
}
