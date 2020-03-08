package com.revature.coursems.repository;

import com.revature.coursems.domain.Course;
import org.springframework.stereotype.Repository;

public interface CourseRepository {
    public void saveCourse(Course course);
}
