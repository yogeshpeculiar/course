package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "texts")
public class Text {
	@Id
	@Column(name="`id`")
	private int id;
	private String name;
	private String content;
public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
