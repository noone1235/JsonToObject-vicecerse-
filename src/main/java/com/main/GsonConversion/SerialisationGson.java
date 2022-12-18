package com.main.GsonConversion;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class SerialisationGson {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("revanth", "audi", 13245678, 54),
				new Person("nagababu", "Rocket", 143, 61));
		Gson gson=new Gson();
		String json=gson.toJson(people);
		
		System.out.println(json);
	}
}
