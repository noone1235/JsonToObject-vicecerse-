package com.main.jaxB;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Students {
	
	@XmlElement
	List<Student> student=new ArrayList<>();

	
	public List<Student> getStudent() {
		return student;
	}
}

