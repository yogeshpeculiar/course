package com.revature.coursems.controller;

import com.revature.coursems.domain.Course;
import com.revature.coursems.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/courses")
    public ResponseEntity<?> saveCourse(@RequestBody Course course)
    {
        System.out.print(course.getName());
        courseService.saveCourse(course);
        return new ResponseEntity<>("Course save successfully", HttpStatus.OK);
    }
    @GetMapping(value="/print")
    public String print(){
        System.out.println("hello");
        return ("hello");
    }
}
