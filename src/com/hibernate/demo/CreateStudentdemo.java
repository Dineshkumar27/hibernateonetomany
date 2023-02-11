package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentdemo {

	public static void main(String[] args) {
		// create sessionfactory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create student object
			System.out.println("Creating new Student Object");

			Student student = new Student("John", "Mosh", "john@gmail.com");
			session.beginTransaction();
			System.out.println("Student object saving....");
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Saved");
		} finally {
			factory.close();
		}
	}

}
