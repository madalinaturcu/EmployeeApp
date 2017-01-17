package com.controller;

import java.util.List;

import com.employee.Employee;

/**
 * This interface is used to specify what methods are necessary in order to manipulate a collection of employees. 
 * @author madalina.turcu
 *
 */
public interface IEmployeeStorage {
	
	public List<Employee> getAll();
	public Employee getById(int id);
	public List<Employee> getByName(String name);
	public List<Employee> getByType(String type);
	public void addEmployee(Employee newEmployee);
}