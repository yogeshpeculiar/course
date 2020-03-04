package com.example.demo.DTO;

import javax.persistence.Column;

import com.example.demo.model.Course;
import com.example.demo.model.Video;

public class CourseSubscribedVideoDTO {
	private int id;
	private Course course;
	private Video video;
	
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
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	
}
