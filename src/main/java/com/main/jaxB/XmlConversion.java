package com.main.jaxB;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;



public class XmlConversion {
	public static void main(String[] args) throws  FileNotFoundException, JAXBException {

		Student s1=new Student(1,"rahul","batia","math",65);
		
		JAXBContext contextOBJ=JAXBContext.newInstance(Student.class);
		Marshaller marshallerObj= contextOBJ.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshallerObj.marshal(s1, new FileOutputStream("./Employee2.xml"));
		
		
	}
}
