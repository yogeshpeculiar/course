package com.example.demo.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "'id'")
	private Integer id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "`level_id`")
	private Level levels;
	@OneToOne
	@JoinColumn(name = "`category_id`")
	private Category categorys;
//	@Transient
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "`course_id`")
	private List<CourseSubscribedVideo> courseSubscribedVideoObj;
//	@Transient
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "`courseId`")
	private List<Docs> Docs;

	@Column(name = "`tag`")
	private String tag;

	@Column(name = "`slug`")
	private String slug;

	@Column(name = "`is_level_override`")
	private boolean is_level_override;

	@Column(name = "`available_for`")
	private boolean available_for;

	@Column(name = "`description`")
	private String desc;

	@Column(name = "`meta_key`")
	private String meta_key;

	@Column(name = "`meta_desc`")
	private String meta_desc;

	@Column(name = "`created_by`")
	private String created_by;

	@Column(name = "`modified_by`")
	private String modified_by;

	@Column(name = "`created_on`")
	private Date created_on;

	@Column(name = "`modified_on`")
	private Date modifiedOn;

	@Column(name = "`name`")
	private String name;

	@Column(name = "`course_icon`")
	private byte[] courseIcon;

	public List<CourseSubscribedVideo> getCourseSubscribedVideoObj() {
		return courseSubscribedVideoObj;
	}

	public void setCourseSubscribedVideoObj(List<CourseSubscribedVideo> courseSubscribedVideoObj) {
		this.courseSubscribedVideoObj = courseSubscribedVideoObj;
	}

	public List<Docs> getDocs() {
		return Docs;
	}

	public void setDocs(List<Docs> docs) {
		Docs = docs;
	}

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		this.modifiedOn = modified_on;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getCourseIcon() {
		return courseIcon;
	}

	public void setCourseIcon(byte[] courseIcon) {
		this.courseIcon = courseIcon;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", levels=" + levels + ", categorys=" + categorys + ", courseSubscribedVideoObj="
				+ courseSubscribedVideoObj + ", Docs=" + Docs + ", tag=" + tag + ", slug=" + slug
				+ ", is_level_override=" + is_level_override + ", available_for=" + available_for + ", desc=" + desc
				+ ", meta_key=" + meta_key + ", meta_desc=" + meta_desc + ", created_by=" + created_by
				+ ", modified_by=" + modified_by + ", created_on=" + created_on + ", modifiedOn=" + modifiedOn
				+ ", name=" + name + ", courseIcon=" + Arrays.toString(courseIcon) + "]";
	}
}
