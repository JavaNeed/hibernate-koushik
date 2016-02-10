package com.sdnext.hibernate.tutorial.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.sdnext.hibernate.tutorial.dto.Course;
import com.sdnext.hibernate.tutorial.dto.Student;
import com.sdnext.hibernate.tutorial.util.HibernateUtil;

public class StudentCourseMain {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();  
        session.beginTransaction(); 
        
        Set<Course> courses = new HashSet<Course>();
        courses.add(new Course("Maths"));
        courses.add(new Course("Computer Science"));
        
        Student student1 = new Student("Eswar", courses);
		Student student2 = new Student("Joe", courses);
		
		session.save(student1);
		session.save(student2);

		session.getTransaction().commit();
		session.close();
	}
}
