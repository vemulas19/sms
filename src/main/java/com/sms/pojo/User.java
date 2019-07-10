package com.sms.pojo;

import java.util.ArrayList;
import java.util.List;

public class User {

	User() {
		System.out.println("Object created for User!!");
	}
	private String name;
	private String salary;
	private List<String> cities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	//populate cities from database
	public void init() {
		System.out.println("Triggered init method!!");
		System.out.println("Cities after creating an object : " + this.getCities());
		List<String> citiesFromDb = new ArrayList<>();
		citiesFromDb.add("Hyderabad");
		citiesFromDb.add("Pune");
		citiesFromDb.add("Chennai");
		citiesFromDb.add("Banglore");
		
		this.setCities(citiesFromDb);
	}
	
	public void destroy() {
		System.out.println("Triggered destroy method!!");
		this.cities = null;
	}
}
