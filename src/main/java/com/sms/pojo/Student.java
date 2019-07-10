package com.sms.pojo;

public class Student {

	Student() {
		System.out.println("Student object created!!");
	}
	
	private int stdId;
	private String name;
	private String collegeName;

	public int getStdId() {  
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	public void init() {
		System.out.println("Triggered init method from Student!!");
		this.collegeName = "Aurora";
	}
	
	public void destroy() {
		System.out.println("Triggered destroy method from Student!!");
		this.collegeName = null;
	}

}
