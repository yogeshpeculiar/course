package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course_subscribed_videos")
public class CourseSubscribedVideo {
	@Id
private int id;
	/*
	 * @OneToMany(targetEntity = Course.class,cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="id") private List<Course> courseId;
	 */
	@Column(name="course_id")
	private int course_id;
	
@Column(name="`video_id`")
private int videoId;
public int getId() {
	return id;
}
public int getCourse_id() {
	return course_id;
}
public void setCourse_id(int course_id) {
	this.course_id = course_id;
}
public void setId(int id) {
	this.id = id;
}


	/*
	 * public List<Course> getCourseId() { return courseId; } public void
	 * setCourseId(List<Course> courseId) { this.courseId = courseId; }
	 */
public int getVideoId() {
	return videoId;
}
public void setVideoId(int videoId) {
	this.videoId = videoId;
}


}
