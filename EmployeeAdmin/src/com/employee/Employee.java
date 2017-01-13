package com.employee;

/**
 * Employee represents the base class, which can be extended by QAEmployee and DevEmployee
 * @author madalina.turcu
 *
 */
public abstract class Employee {

	public String name;
	public String email;
	public int age;
	
	/**
	 * Initialize a new employee
	 * @param name The name of an employee
	 * @param email The email of the employee
	 * @param age The age of the employee
	 */
	
	public Employee(String name, String email, int age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	/**
	 * Set the name to the employee
	 * @param name The name of an employee
	 */
	public void setName(String name) {
		this.name = name;
	}
}