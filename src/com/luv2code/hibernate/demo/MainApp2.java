package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.enitity.Instructor;
import com.luv2code.hibernate.demo.enitity.InstructorDetail;

public class MainApp2 {

	public static void main(String[] args) {
		
		// create SessionFactory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		//create Session
		Session session = factory.getCurrentSession();
		Instructor instructor = new Instructor("Bartek","Lepa","bl@gmail.com");
		InstructorDetail instructordetail = new InstructorDetail("http:bl.com/youtube","playing in football");;
		try {
		
			//begin transaction
			session.beginTransaction();
			
			//save isntructor object 
			instructor.setInstructorDetail(instructordetail);
			session.save(instructor);
	
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			//close session, because we don't want more leaks
			session.close();
			factory.close();
	}

}
}
