package com.example.demo.DTO;

import java.util.Date;
import java.util.List;

public class CourseDTO {
private int id;
private String tag; 
private String slug;
private boolean is_level_override; 
private boolean available_for;
private String desc;
private String meta_key;
private String meta_desc;
private String name;

private LevelDTO levels;
private CategoryDTO categorys;
private List<CourseSubscribedVideoDTO> CourseSubscribedVideoObj;
//private List<CourseSubscribedTextDTO> CourseSubscribedTextObj;
private List<DocsDTO> Docs;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


public List<DocsDTO> getDocs() {
	return Docs;
}
public void setDocs(List<DocsDTO> docs) {
	Docs = docs;
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
public void setCategorys(CategoryDTO categorys) {
	this.categorys = categorys;
}
public String getTag() {
	return tag;
}
public void setTag(String tag) {
	this.tag = tag;
}
public String getSlug() {
	return slug;
}
public void setSlug(String slug) {
	this.slug = slug;
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
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<CourseSubscribedVideoDTO> getCourseSubscribedVideoObj() {
	return CourseSubscribedVideoObj;
}
public void setCourseSubscribedVideoObj(List<CourseSubscribedVideoDTO> courseSubscribedVideoObj) {
	CourseSubscribedVideoObj = courseSubscribedVideoObj;
}
	/*
	 * public List<CourseSubscribedTextDTO> getCourseSubscribedTextObj() { return
	 * CourseSubscribedTextObj; } public void
	 * setCourseSubscribedTextObj(List<CourseSubscribedTextDTO>
	 * courseSubscribedTextObj) { CourseSubscribedTextObj = courseSubscribedTextObj;
	 * }
	 */

}
