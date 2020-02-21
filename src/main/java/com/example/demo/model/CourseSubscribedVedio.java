package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_subscribed_videos")
public class CourseSubscribedVedio {
	@Id
private int id;
@Column(name="`courses_id`")
private int courseId;
@Column(name="`video_id`")
private int videoId;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCourseId() {
	return courseId;
}
public void setCourseId(int courseId) {
	this.courseId = courseId;
}
public int getVideoId() {
	return videoId;
}
public void setVideoId(int videoId) {
	this.videoId = videoId;
}


}
