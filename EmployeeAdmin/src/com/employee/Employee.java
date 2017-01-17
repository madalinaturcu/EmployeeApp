package com.employee;

/**
 * Employee represents the base class, which can be extended by QAEmployee and DevEmployee
 * @author madalina.turcu
 *
 */
public abstract class Employee {
	
	protected int id;
	protected String name;
	protected String email;
	protected int age;
	protected String employeeType;
	
	/**
	 * Initialize a new employee
	 * @param name The name of the employee
	 * @param email The email of the employee
	 * @param age The age of the employee
	 * @param employeeType The employeeType of the employee
	 */
	
	public Employee(int id, String name, String email, int age, String employeeType) {
		//TODO assign the id dynamically
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.employeeType = employeeType;
	}
	
	/**
	 * Set the name to the employee
	 * @param name The name of the employee
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set the email to the employee
	 * @param email The email of the employee
	 */
	public void setEmail(String email) {
		this.email = email;

		//TODO write restrictions for the type of an email
	}
	
	/**
	 * Set the age to the employee
	 * @param age The age of the employee
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Set the employeeType to the employee
	 * @param employeeType The employeeType of the employee
	 */
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	
	/**
	 * Get the id from the employee
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the name from the employee
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get the email from the employee
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Get the age from the employee
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Get the employeeType from the employee
	 */
	public String getEmployeeType() {
		return employeeType;
	}
}