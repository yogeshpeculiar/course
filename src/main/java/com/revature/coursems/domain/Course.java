package com.revature.coursems.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "level_id")
    private Level levelObj;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category categoryObj;

    @OneToMany
    @JoinColumn(name="course_id")
    private List<Course> courseObj;
    
    private String tag;
    private String slug;
    @Column(name = "is_level_override")
    private Boolean isLevelOverride;
    @Column(name = "available_for")
    private Boolean availableFor;
    private String description;
    @Column(name = "meta_key")
    private String metaKey;
    @Column(name = "meta_desc")
    private String metaDesc;
    @Column(name = "course_icon")
    private String course_icon;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "created_on")
    private LocalDate cratedOn;
    @Column(name = "modified_on")
    private LocalDate modifiedOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getIsLevelOverride() {
        return isLevelOverride;
    }

    public void setIsLevelOverride(Boolean isLevelOverride) {
        this.isLevelOverride = isLevelOverride;
    }

    public Boolean getAvailableFor() {
        return availableFor;
    }

    public void setAvailableFor(Boolean availableFor) {
        this.availableFor = availableFor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetaKey() {
        return metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    public String getMetaDesc() {
        return metaDesc;
    }

    public void setMetaDesc(String metaDesc) {
        this.metaDesc = metaDesc;
    }

    public String getCourse_icon() {
        return course_icon;
    }

    public void setCourse_icon(String course_icon) {
        this.course_icon = course_icon;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getCratedOn() {
        return cratedOn;
    }

    public void setCratedOn(LocalDate cratedOn) {
        this.cratedOn = cratedOn;
    }

    public LocalDate getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDate modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Level getLevelObj() {
        return levelObj;
    }

    public void setLevelObj(Level levelObj) {
        this.levelObj = levelObj;
    }

    public Category getCategoryObj() {
        return categoryObj;
    }

    public void setCategoryObj(Category categoryObj) {
        this.categoryObj = categoryObj;
    }

  
    

}
