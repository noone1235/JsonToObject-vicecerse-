package com.main.jaxB;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;



public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String subject;
	private int marks;
	public Student(int id, String firstName, String lastName, String subject, int marks) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subject=subject;
		this.marks = marks;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@XmlElement
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@XmlElement(name="standard")
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@XmlElement
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	
}
