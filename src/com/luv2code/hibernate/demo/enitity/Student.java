package com.luv2code.hibernate.demo.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int ID;

@Column(name="first_Name")
private String firstName;

@Column(name="last_Name")
private String lastName;


@Column(name="email")
private String email;


public Student() {
	
}


public Student(String firstName, String lastName, String email) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
}


public int getID() {
	return ID;
}


public void setID(int iD) {
	ID = iD;
}


public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


@Override
public String toString() {
	return "Student [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
}


}



