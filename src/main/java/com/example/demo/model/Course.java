package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name = "courses")
public class Course {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name="`level_id`")
	private Level levels;
	/*
	 * @Transient private long levelId;
	 * 
	 * 
	 * public long getLevelId() { return levelId; } public void setLevelId(long
	 * levelId) { this.levelId = levelId; }
	 */
	@OneToOne
	@JoinColumn(name="`category_id`")
	private Category categorys;
	
//	@ManyToOne(targetEntity = CourseSubscribedVideo.class,cascade = CascadeType.ALL)
//	@JoinColumn(name="video_id")
//	private CourseSubscribedVideo l_courseSubvedobj;
	
	/*
	 * @OneToMany
	 *  
	 * @JoinColumn(name="'course_subscribed_video_id'") private
	 * List<CourseSubscribedText> CourseSubscribedTextObj;
	 */
	
	/*
	 * @OneToMany(cascade=CascadeType.ALL)
	 * 
	 * @JoinTable(name="course_subscribed_videos",
	 * joinColumns={@JoinColumn(name="course_id", referencedColumnName="id")} ,
	 * inverseJoinColumns={@JoinColumn(name="video_id", referencedColumnName="id")})
	 */

@OneToMany
@JoinColumn(name="id")
private List<CourseSubscribedVideo> CourseSubscribedVideoObj;

@OneToMany
@JoinColumn(name="id")
private List<CourseSubscribedText> CourseSubscribedTextObj;
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="`content_attachement_id`") private CourseContent
	 * content_attachements;
	 */
	
	

	public List<CourseSubscribedText> getCourseSubscribedTextObj() {
	return CourseSubscribedTextObj;
}
public void setCourseSubscribedTextObj(List<CourseSubscribedText> courseSubscribedTextObj) {
	CourseSubscribedTextObj = courseSubscribedTextObj;
}
	@Column(name="`name`")
	private String name;
	
	public List<CourseSubscribedVideo> getCourseSubscribedVideoObj() {
		return CourseSubscribedVideoObj;
	}
	public void setCourseSubscribedVideoObj(List<CourseSubscribedVideo> courseSubscribedVideoObj) {
		CourseSubscribedVideoObj = courseSubscribedVideoObj;
	}
	@Column(name="`tag`")
	private String tag;
	@Column(name="`slug`")
	private String slug;
	@Column(name="`is_level_override`")
	private boolean is_level_override; 
	@Column(name="`available_for`")
	private boolean available_for;
	@Column(name="`description`")
	private String desc;
	@Column(name="`meta_key`")
	private String meta_key;
	@Column(name="`meta_desc`")
	private String meta_desc;
	@Column(name="`created_by`")
	private String created_by;
	@Column(name="`modified_by`")
	private String modified_by;
	@Column(name="`created_on`")
	private Date created_on;
	@Column(name="`modified_on`")
	private Date modifiedOn;
	
	/*
	 * public CourseContent getContent_attachements() { return content_attachements;
	 * } public void setContent_attachements(CourseContent content_attachements) {
	 * this.content_attachements = content_attachements; }
	 */
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public Category getCategorys() {
		return categorys;
	}
	public void setCategorys(Category categorys) {
		this.categorys = categorys;
	}
	
	public Level getLevels() {
		return levels;
	}
	public void setLevels(Level levels) {
		this.levels = levels;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public Date getModified_on() {
		return modifiedOn;
	}
	public void setModified_on(Date modified_on) {
		this.modifiedOn  = modified_on;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public List<CourseSubscribedText> getCourseSubscribedTextObj() { return
	 * CourseSubscribedTextObj; } public void
	 * setCourseSubscribedTextObj(List<CourseSubscribedText>
	 * courseSubscribedTextObj) { CourseSubscribedTextObj = courseSubscribedTextObj;
	 * }
	 */

	

}
