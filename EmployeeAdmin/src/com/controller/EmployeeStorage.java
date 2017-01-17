package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.employee.DevEmployee;
import com.employee.Employee;
import com.employee.QAEmployee;

/**
 * This class implements the methods declared in IEmployeeStorage. 
 * @author madalina.turcu
 *
 */

public class EmployeeStorage implements IEmployeeStorage{

	private static List<Employee> employeeList = new ArrayList<Employee>(){
	    {
	        add(new QAEmployee(1, "Mada", "mada@gmail.com", 23, "QA", true));
	        add(new QAEmployee(2, "Ana", "ana@gmail.com", 21, "QA", false));
	        add(new DevEmployee(3, "Eugen", "e@gmail.com", 21, "DEV", false));
	        add(new DevEmployee(4, "Mircea", "m@gmail.com", 33, "DEV", true)); 
	    }
	 };
	 
	 /**
	  * This method returns all the employees from the list.
	  */
	 public List<Employee> getAll() {
		 return employeeList;
	 }
	 
	 /**
	  * This method returns a specific employee, found by id.
	  */
	 public Employee getById(int id) {
		 
		 for(int i = 0; i < employeeList.size(); i++) {
			 if (employeeList.get(i).getId() == id) {
				 return employeeList.get(i);
			 }
		 }
		 
		 return null;
	 }
	 
	 /**
	  * This method returns a specific employee, found by name.
	  */
	 public List<Employee> getByName(String name) {
		 
		 List<Employee> returnList = new ArrayList<Employee>();
		 
		 for(int i = 0; i < employeeList.size(); i++) {
			 if (employeeList.get(i).getName().equals(name)) {
				 returnList.add(employeeList.get(i));
			 }
		 }
		 
		 return returnList;
	 }
	 
	 /**
	  * This method returns a specific employee, found by type (QA,DEV).
	  */
	 public List<Employee> getByType(String type) {
		 
		 List<Employee> returnList = new ArrayList<Employee>();
		 
		 for(int i = 0; i < employeeList.size(); i++) {
			 if (employeeList.get(i).getEmployeeType().equals(type)){
				 returnList.add(employeeList.get(i));
			 }
		 }
		 return returnList;
	 }
	 
	 /**
	  * This method adds a new employee in the list.
	  */
	 public void addEmployee (Employee newEmployee) {
		 
		  employeeList.add(newEmployee);
	 }
}
