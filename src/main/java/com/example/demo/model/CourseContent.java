package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course_content")
public class CourseContent {
	@Id
private int id;
	@OneToMany
	@JoinColumn(name="`id`")
	private List<Video> video_id;
	@OneToMany
	@JoinColumn(name="`id`")
	private List<Text> text_id;
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Video> getVideo_id() {
		return video_id;
	}
	public void setVideo_id(List<Video> video_id) {
		this.video_id = video_id;
	}
	public List<Text> getText_id() {
		return text_id;
	}
	public void setText_id(List<Text> text_id) {
		this.text_id = text_id;
	}
	



}
