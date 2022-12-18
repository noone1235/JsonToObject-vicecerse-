package com.main.GsonConversion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import com.main.JsonConversion.Person;

public class GsonConversion {
	public static void main(String[] args)
			throws FileNotFoundException, SQLException, IllegalArgumentException, IllegalAccessException {

		//List<Person> people = new ArrayList<Person>();
		Gson gson = new Gson();
		BufferedReader reader = new BufferedReader(new FileReader(
				"C:\\NarasimhaAsuri\\Workspace2\\RodyBaby\\src\\main\\java\\com\\main\\GsonConversion\\Person.json"));
		Person person = gson.fromJson(reader, Person.class);

		// **uploading to dataBase
		// 1.establish connection and create a statement
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/testdb?user=root&password=Kanerika@1385");
		PreparedStatement stmt = con.prepareStatement("INSERT INTO people(name,salary,age,car)  VALUES(?,?,?,?)");

		int i = 0;
		Class<?> clapp = person.getClass();
		Field[] fields = clapp.getDeclaredFields();
		// 2.for every field in person
		for (Field field : fields) {
			field.setAccessible(true);
			// 2.1.1.setInt statement for Int field
			if (field.getType() == int.class) {
				stmt.setInt(i + 1, field.getInt(person));
				i++;
			} else {
				stmt.setString(i + 1, field.get(person).toString());
				i++;
			}
		}
		// 2.2.execute for after a whole person's data is set into statement
		stmt.execute();
		i = 0;
	}

}
