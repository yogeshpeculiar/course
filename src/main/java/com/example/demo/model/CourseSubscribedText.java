package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "course_subscribed_texts")
public class CourseSubscribedText {
	@Id
	private int id;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="`courses_id`")
	private Course course;
	
	@OneToOne
	@JoinColumn(name="`text_id`")
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
