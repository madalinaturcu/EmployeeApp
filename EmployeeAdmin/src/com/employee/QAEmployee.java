package com.employee;

/**
 * QAEmployee represents a type of an Employee (QA). 
 * This class extends Employee class and can be extended by TL QA.
 * @author madalina.turcu
 * 
 */
public class QAEmployee extends Employee {
	
	public Boolean hasPatience;
	
	/**
	 * Initialize a new QA employee
	 * @param hasPatience The 'hasPatience' of the QA employee
	 */
	public QAEmployee(int id, String name, String email, int age, Boolean hasPatience) {
		super(id, name, email, age);
		this.hasPatience = hasPatience;
	}
	
	/**
	 * Set the 'hasPatience' to the employee
	 * @param hasPatience The 'hasPatience' of the employee
	 */
	public void setHasPatience(Boolean hasPatience) {
		this.hasPatience = hasPatience;
	}
	
	/**
	 * Get the 'hasPatience' from the employee
	 */
	public Boolean getHasPatience() {
		return hasPatience;
	}
	
	/**
	 *  This method is used to update the information of the QAEmployee
	 */
	public void updateDetails( String newName, String newEmail, int newAge, Boolean newHasPatience) {
		this.name = newName;
		this.email = newEmail;
		this.age = newAge;
		this.hasPatience = newHasPatience;
		
	}
	
}

