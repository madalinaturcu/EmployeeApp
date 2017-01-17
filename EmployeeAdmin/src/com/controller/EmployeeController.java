package com.controller;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.employee.DevEmployee;
import com.employee.Employee;
import com.employee.QAEmployee;

/**
 * This class is used to make actions on Employee:
 * GET - view all the Employees + filter Employees
 * POST - add new Employees
 * PUT - update existing Employee
 * @author madalina.turcu
 *
 */
@Path("/employeeList")
public class EmployeeController {
	
	private ObjectMapper mapper = new ObjectMapper();
	private IEmployeeStorage storage = new EmployeeStorage();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String ShowEmployeeList(
			@DefaultValue("id") @QueryParam("filter") String filter, 
			@DefaultValue("0") @QueryParam("value") String value) throws JsonGenerationException, JsonMappingException, IOException {

		List<Employee> returnList = new ArrayList<Employee>();

		switch(filter) {
			case "id":
				if (Integer.parseInt(value) == 0) {
					returnList.addAll(storage.getAll());
				} else {
					returnList.add(storage.getById(Integer.parseInt(value)));
				}
				break;
			case "name": 
				if (value == "") {
					returnList.addAll(storage.getAll());
				} else {
					returnList.addAll(storage.getByName(value));
				}
				break;
			case "employeeType": 
				if (value == "") {
					returnList.addAll(storage.getAll());
				} else {
					returnList.addAll(storage.getByType(value));
				}
				break;
			default: returnList.addAll(storage.getAll());
		}
		
		return mapper.writeValueAsString(returnList);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String AddEmployee(String employee) throws JSONException, JsonGenerationException, JsonMappingException, IOException {
		
		JSONObject jObject  = new JSONObject(employee);
		
		if (jObject.getString("employeeType").equals("QA")) {
			QAEmployee newQAEmployee = new QAEmployee(jObject.getInt("id"), jObject.getString("name"), jObject.getString("email"), jObject.getInt("age"), jObject.getString("employeeType"), jObject.getBoolean("hasPatience"));
			storage.addEmployee(newQAEmployee);
		} else {
			DevEmployee newDevEmployee = new DevEmployee(jObject.getInt("id"), jObject.getString("name"), jObject.getString("email"), jObject.getInt("age"), jObject.getString("employeeType"), jObject.getBoolean("isQuickLearning"));
			storage.addEmployee(newDevEmployee);
		}
		
		return  null;
	}
	
	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_JSON)
	public String EditEmployee(String employee) throws JSONException, JsonGenerationException, JsonMappingException, IOException {
		
		JSONObject jObject = new JSONObject(employee);
		Employee returnEmp = storage.getById(jObject.getInt("id"));
		
		if (jObject.getString("employeeType").equals("QA")) {
			((QAEmployee) returnEmp).updateDetails(jObject.getString("name"), jObject.getString("email"), jObject.getInt("age"), jObject.getString("employeeType"), jObject.getBoolean("hasPatience"));
		} else if (jObject.get("employeeType").equals("DEV")) {
			((DevEmployee) returnEmp).updateDetails(jObject.getString("name"), jObject.getString("email"), jObject.getInt("age"), jObject.getString("employeeType"), jObject.getBoolean("isQuickLearning"));
		}
		
		return mapper.writeValueAsString(returnEmp);
	}
}
