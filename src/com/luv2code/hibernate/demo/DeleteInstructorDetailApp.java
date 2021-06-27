package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.enitity.Instructor;
import com.luv2code.hibernate.demo.enitity.InstructorDetail;

public class DeleteInstructorDetailApp {

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
					
					//get instructor detail object 
					int theId=3;
					InstructorDetail detail1= 
							session.get(InstructorDetail.class, theId);
					
					//print the detail
					System.out.println("instructorDetail: "+detail1);
					
					//print the associated instructor
					System.out.println("the associated instructor: "+detail1.getInstructor());
					
					//delete instructor object
					// remove the associated object reference
					System.out.println("deleting instructor detail");
					detail1.getInstructor().setInstructorDetail(null); //!!!!! bardzo wa¿ne przy usuwaniu
					session.delete(detail1);
			
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
