package com.revature.coursems.repository.impl;

import com.revature.coursems.domain.Course;
import com.revature.coursems.repository.CourseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCourse(Course course)
    {
        Session session = this.sessionFactory.getCurrentSession();
        //Here begin transaction
        session.beginTransaction();
        session.save(course);
        //Here changes get permanent
        session.getTransaction().commit();
    }
}
