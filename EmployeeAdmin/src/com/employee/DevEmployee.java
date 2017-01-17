package com.employee;

/**
 * DevEmployee represents a type of an Employee (Dev). 
 * This class extends Employee class and can be extended by TL Dev.
 * @author madalina.turcu
 * 
 */
public class DevEmployee extends Employee {
	
	public Boolean isQuickLearning;
	
	/**
	 * Initialize a new Dev employee
	 * @param isQuickLearning The 'isQuickLearning' of the Dev employee
	 */
	public DevEmployee(int id, String name, String email, int age, String employeeType, Boolean isQuickLearning) {
		super(id, name, email, age, employeeType);
		this.isQuickLearning = isQuickLearning;
	}
	
	/**
	 * Set the 'isQuickLearning' to the employee
	 * @param isQuickLearning The 'isQuickLearning' of the employee
	 */
	public void setIsQuickLearning(Boolean isQuickLearning) {
		this.isQuickLearning = isQuickLearning;
	}
	
	/**
	 * Get the 'isQuickLearning' from the employee
	 */
	public Boolean getIsQuickLearning() {
		return isQuickLearning;
	}
	
	/**
	 *  This method is used to update the information of the DevEmployee
	 */
	public void updateDetails( String newName, String newEmail, int newAge, String newEmployeeType, Boolean newIsQuickLearning) {
		this.name = newName;
		this.email = newEmail;
		this.age = newAge;
		this.employeeType = newEmployeeType;
		this.isQuickLearning = newIsQuickLearning;
	}
	
}

