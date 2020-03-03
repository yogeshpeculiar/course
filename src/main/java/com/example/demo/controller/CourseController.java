package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CourseDAO;
import com.example.demo.dao.courseDAOImp;
import com.example.demo.model.Course;
import com.example.demo.model.CourseSubscribedVideo;
import com.example.demo.service.CourseService;
import com.example.demo.DTO.insertDTO;
import com.example.demo.DTO.updateDTO;;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
    

	@PostMapping(value="")
	public void addCourse(@RequestBody insertDTO insertDTOobj  ) {
		courseService.addCourse(insertDTOobj);
	}
	
	@GetMapping("")
	public List<Course> viewCourse() {
		return courseService.view();
	}
	@PutMapping("")
	public void update(@RequestBody updateDTO c) {
		System.out.println(c.getId());
		courseService.update(c); 
		 }
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		return courseService.delete(id);
	}
	@PostMapping(value="/addImage/{filename}")
	public String addImage(@PathVariable String filename) {
		return courseService.addImage(filename);
		
			
	}
}
