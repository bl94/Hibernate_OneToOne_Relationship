package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.enitity.Instructor;
import com.luv2code.hibernate.demo.enitity.InstructorDetail;

public class MainDeleteApp {

	public static void main(String[] args) {
		
		// create SessionFactory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		//create Session
		Session session = factory.getCurrentSession();
		try {
			
		

			//begin transaction
			session.beginTransaction();
			
			//get object by primary key(id)
			int theId = 1;
			Instructor instructor =
					session.get(Instructor.class, theId);
			System.out.println("Found instructor : "+instructor);
			
			//delete the object 
			//Note : will delele ALSO associated "detail" object
			//because CascadeType.ALL
			if(instructor!=null)
			{
			System.out.println("Deleting object"+ instructor);
				session.delete(instructor);
			}
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
	}

}
}
