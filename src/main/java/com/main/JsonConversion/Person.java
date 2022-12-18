package com.main.JsonConversion;

public class Person {
	private String name;
	private int salary;
	private int age;
	private String car;
	public Person() {
		super();
		this.name = null;
		this.salary = 0;
		this.age = 0;
		this.car = null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	
}
