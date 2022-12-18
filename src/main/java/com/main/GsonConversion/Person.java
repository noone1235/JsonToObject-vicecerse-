package com.main.GsonConversion;

public class Person {
	private String name;
	private String car;
	private int salary;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person() {
		super();
	}
	public Person(String name, String car, int salary, int age) {
		super();
		this.name = name;
		this.car = car;
		this.salary = salary;
		this.age = age;
	}
	
	
}
