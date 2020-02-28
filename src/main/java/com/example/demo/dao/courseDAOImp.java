package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Course;
import com.example.demo.model.CourseSubscribedVideo;

import DTO.updateDTO;
@Repository
public class courseDAOImp implements CourseDAO {

	@Autowired
	EntityManager em;
	
	@Override
	public void insert(Course c) {
	
		em.persist(c);
		
		}
	public List<Course> view(){
		List<Course> l=em.createQuery("from Course",Course.class).getResultList();//here in "from Course" Course is the model name
		return l;
	}
	public boolean isCourseIdExists(int id) {
		Course cc=em.find(Course.class, id);
		System.out.println(cc);
		if(cc==null)
			return false;
		else 
			return true;
	} 
	public Course update(Course c) {
		
		return em.merge(c);
	}
	public String delete(int id) {
		Course cc=em.find(Course.class, id);
		if(cc!=null) {
			em.remove(cc);
		return "deletion successful";
		}
		else
			return "deletion failed as the given id does not exists...";
	}
	
	@Override
	public Course findCourseByID(int id) {
		Course cc=em.find(Course.class, id);
		return cc;
	}
	

}
