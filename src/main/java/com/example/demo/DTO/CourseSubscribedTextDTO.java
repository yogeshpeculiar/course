package com.example.demo.DTO;

import com.example.demo.model.Course;
import com.example.demo.model.Docs;

public class CourseSubscribedTextDTO {
	private int id;
	private Course course;
	private Docs text;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Docs getText() {
		return text;
	}
	public void setText(Docs text) {
		this.text = text;
	}
	
}
