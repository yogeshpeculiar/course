package DTO;

import java.util.List;

import javax.persistence.Column;

import com.example.demo.model.Category;
import com.example.demo.model.CourseSubscribedText;
import com.example.demo.model.CourseSubscribedVideo;
import com.example.demo.model.Level;

public class updateDTO {
	private int id;
//	private LevelDTO levelDTOObj;
//	private CategoryDTO categoryDTOObj;
//	private List<CourseSubscribedVideo> CourseSubscribedVideoObj;
//	private List<CourseSubscribedText> CourseSubscribedTextObj;
	private String tag;

	private boolean is_level_override; 

	private boolean available_for;

	private String desc;

	private String meta_key;

	private String meta_desc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
//	public List<CourseSubscribedVideo> getCourseSubscribedVideoObj() {
//		return CourseSubscribedVideoObj;
//	}
//
//	public void setCourseSubscribedVideoObj(List<CourseSubscribedVideo> courseSubscribedVideoObj) {
//		CourseSubscribedVideoObj = courseSubscribedVideoObj;
//	}
//
//	public List<CourseSubscribedText> getCourseSubscribedTextObj() {
//		return CourseSubscribedTextObj;
//	}
//
//	public void setCourseSubscribedTextObj(List<CourseSubscribedText> courseSubscribedTextObj) {
//		CourseSubscribedTextObj = courseSubscribedTextObj;
//	}

//	public LevelDTO getLevelDTOObj() {
//		return levelDTOObj;
//	}
//
//	public void setLevelDTOObj(LevelDTO levelDTOObj) {
//		this.levelDTOObj = levelDTOObj;
//	}

//	public CategoryDTO getCategoryDTOObj() {
//		return categoryDTOObj;
//	}
//
//	public void setCategoryDTOObj(CategoryDTO categoryDTOObj) {
//		this.categoryDTOObj = categoryDTOObj;
//	}


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
