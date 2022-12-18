package com.main.JsonConversion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonConversion {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, SQLException,
			IllegalArgumentException, IllegalAccessException {

		// **json text to Person object

		// 1.Parse the data and store into JSONArray, every person's data
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser
				.parse(new FileReader("./src/main/java/com/main/JsonConversion/Person.json"));
		JSONArray jsonArray = (JSONArray) jsonObject.get("People");// Array is of object People
		// System.out.println(jsonObject.get("Person")+" \n"+jsonArray.get(0));

		// 2.instantize empty ArrayList to recieve the data from .json file
		List<Person> people = new ArrayList<Person>();

		// 3.Run over each person to assign it to objects in the List people
		for (Object object : jsonArray) {
			// 3.1.for every person in jsonArray instantize a new Person object and add it
			// to people
			Person person = new Person();
			people.add(person);

			Class<?> clapp = person.getClass();

			// 3.2.Get the data of a single JSONObject person
			JSONObject personObj = (JSONObject) object; // object has person's data from .json file with the tag person
			JSONObject p = (JSONObject) personObj.get("Person"); // get the array with name Person without the tag
																	// person

			String k = "";
			//3.3.loop over all fields in the object person created above
			for (Field field : clapp.getDeclaredFields()) {
				field.setAccessible(true);
				//3.3.1.if annotation is present its value is taken
				if (field.isAnnotationPresent(ChangeName.class)) {
					k = field.getAnnotation(ChangeName.class).value();
				} else {
					k = field.getName();
				}
				
				//3.3.2.value of json data is set into object
				if (field.getType() == int.class) {
					field.set(person, Integer.parseInt(p.get(k).toString()));
				} else {
					field.set(person, p.get(k));
				}
				System.out.println(field.get(person));
			}
			System.out.println();
			// System.out.println(p);
		}

		//**upload object data into database
		
		//1.establish connection and create a statement
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/testdb?user=root&password=Kanerika@1385");
		PreparedStatement stmt = con.prepareStatement("INSERT INTO people(name,salary,age,car)  VALUES(?,?,?,?)");

		int i = 0;
		
		//2.for every person in people 
		for (Person person : people) {
			Class<?> clapp = person.getClass();
			Field[] fields = clapp.getDeclaredFields();
			//2.1.for every field in person
			for (Field field : fields) {
				field.setAccessible(true);
				//2.1.1.setInt statement for Int field
				if (field.getType() == int.class) {
					stmt.setInt(i + 1, field.getInt(person));
					i++;
				} else {
					stmt.setString(i + 1, field.get(person).toString());
					i++;
				}
			}
			//2.2.execute for after a whole person's data is set into statement
			stmt.execute();
			i = 0;
		}
	}
}
