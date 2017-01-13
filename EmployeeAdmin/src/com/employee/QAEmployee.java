package com.employee;

public class QAEmployee extends Employee{
	
	public Boolean hasPatience;
	
	public QAEmployee(String name, String email, int age, Boolean hasPatience) {
		super(name, email, age);
		this.hasPatience = hasPatience;
		
	}
}
