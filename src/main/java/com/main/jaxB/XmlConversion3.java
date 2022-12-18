package com.main.jaxB;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

public class XmlConversion3 {
	public static void main(String[] args) throws SQLException, ParserConfigurationException, SAXException, IOException,
			JAXBException, IllegalArgumentException, IllegalAccessException {

		//unmarshalling
		JAXBContext context = JAXBContext.newInstance(Students.class);
		Students s = (Students) context.createUnmarshaller().unmarshal(new FileReader("./Students.xml"));
		List<Student> students = s.getStudent();

		//uploading to database
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/testdb?user=root&password=Kanerika@1385");
		PreparedStatement stmt = conn.prepareStatement(
				"INSERT INTO students(\n" + " id, firstName, lastName, subject, marks)\n" + "values(?, ?, ?, ?, ?)\n");
		int i = 0;
		for (Student student : students) {
			Class<?> test = student.getClass();
			Field[] field = test.getDeclaredFields();

			for (Field f : field) {
				f.setAccessible(true);
				if (f.getType() == int.class) {
					stmt.setInt(i + 1, f.getInt(student));
					i++;
				} else {
					stmt.setString(i + 1, f.get(student).toString());
					i++;
				}
			}
			stmt.execute();
			i = 0;
		}
	}

}
