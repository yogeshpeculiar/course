package com.example.demo.DTO;

import java.util.List;

import javax.persistence.Column;

import com.example.demo.model.Category;
import com.example.demo.model.CourseSubscribedText;
import com.example.demo.model.CourseSubscribedVideo;
import com.example.demo.model.Level;

public class updateDTO {
	private int id;
	private String name;
	private String tag;
	private boolean is_level_override; 
	private boolean available_for;
	private String desc;
	private String meta_key;
	private String meta_desc;
	
	private LevelDTO levels;
	private CategoryDTO categorys;
	private DocsDTO Docs;
	/*
	 * private CourseSubscribedTextDTO CourseSubscribedTextObj; private
	 * CourseSubscribedVideoDTO CourseSubscribedVideoObj;
	 */
	
	public String getName() {
		return name;
	}

	public DocsDTO getDocs() {
		return Docs;
	}

	public void setDocs(DocsDTO docs) {
		Docs = docs;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


	public LevelDTO getLevels() {
		return levels;
	}

	public void setLevels(LevelDTO levels) {
		this.levels = levels;
	}

	public CategoryDTO getCategorys() {
		return categorys;
	}

	public void setCategors(CategoryDTO categorys) {
		this.categorys = categorys;
	}

	/*
	 * public CourseSubscribedTextDTO getCourseSubscribedTextObj() { return
	 * CourseSubscribedTextObj; }
	 * 
	 * public void setCourseSubscribedTextObj(CourseSubscribedTextDTO
	 * courseSubscribedTextObj) { CourseSubscribedTextObj = courseSubscribedTextObj;
	 * }
	 * 
	 * public CourseSubscribedVideoDTO getCourseSubscribedVideoObj() { return
	 * CourseSubscribedVideoObj; }
	 * 
	 * public void setCourseSubscribedVideoObj(CourseSubscribedVideoDTO
	 * courseSubscribedVideoObj) { CourseSubscribedVideoObj =
	 * courseSubscribedVideoObj; }
	 */

	public void setCategorys(CategoryDTO categorys) {
		this.categorys = categorys;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isIs_level_override() {
		return is_level_override;
	}

	public void setIs_level_override(boolean is_level_override) {
		this.is_level_override = is_level_override;
	}

	public boolean isAvailable_for() {
		return available_for;
	}

	public void setAvailable_for(boolean available_for) {
		this.available_for = available_for;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMeta_key() {
		return meta_key;
	}

	public void setMeta_key(String meta_key) {
		this.meta_key = meta_key;
	}

	public String getMeta_desc() {
		return meta_desc;
	}

	public void setMeta_desc(String meta_desc) {
		this.meta_desc = meta_desc;
	}
	
	
	
}
