package com.main.jaxB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

public class XmlConversion2 {
	public static void main(String[] args) throws FileNotFoundException, JAXBException {
		JAXBContext context = JAXBContext.newInstance(Students.class);
		
		Students s = (Students) context.createUnmarshaller().unmarshal(new FileReader("./Students.xml"));
	    List<Student> students=s.getStudent();
	    
	    System.out.println(students.get(2).getLastName());
	    
		
	}
}
