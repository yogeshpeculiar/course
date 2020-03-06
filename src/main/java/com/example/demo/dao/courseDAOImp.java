package com.example.demo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Course;
@Repository
public class courseDAOImp implements CourseDAO {

	@Autowired
	EntityManager em;
	
	@Override
	public void insert(Course c) {
		 c.getDocs().forEach( docObj -> {
			 docObj.setCourse(c);
		 });
		//courseObj.setCourseIcon(addImage("h"));
		 c.getCourseSubscribedVideoObj().forEach( videoObj -> {
			 videoObj.setCourse(c);
		 });
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
	@Override
	public byte[] addImage(String filename) {
		File file = new File("C:/Users/Training/Downloads/dog.jpg");
		byte[] bFile = new byte[(int) file.length()];
		 try {
		     FileInputStream fileInputStream = new FileInputStream(file);
		     //convert file into array of bytes
		     fileInputStream.read(bFile);
		     fileInputStream.close();
	        } catch (Exception e) {
		     e.printStackTrace();
	        }
		 
		 
		return bFile;
	}

}
