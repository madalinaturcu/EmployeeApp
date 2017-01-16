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

import com.employee.QAEmployee;

/**
 * This class is used to make actions on QAEmployee:
 * GET - view all the QAEmployees + filter QAEmployees
 * POST - add new QAEmployees
 * PUT - update existing QAEmployee
 */
@Path("/employeeList")
public class QAEmployeeController {
	
	private ObjectMapper mapper = new ObjectMapper();

	static List<QAEmployee> employeeList = new ArrayList<QAEmployee>(){
	    {
	        add(new QAEmployee(1, "Mada", "mada@gmail.com", 23, true));
	        add(new QAEmployee(2, "Ana", "ana@gmail.com", 21, false));
	        add(new QAEmployee(3, "Ema", "ema@gmail.com", 33, true));  
	    }
	 };
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String ShowEmployeeList(
			@DefaultValue("id") @QueryParam("filter") String filter, 
			@DefaultValue("0") @QueryParam("value") String value) throws JsonGenerationException, JsonMappingException, IOException {
		
		String returnValue = "";
		
		switch(filter) {
			case "id":
				if (Integer.parseInt(value) == 0) {
					returnValue = mapper.writeValueAsString(employeeList);
				} else for (int i = 0; i < employeeList.size(); i++) {
					if (employeeList.get(i).getId() == Integer.parseInt(value)) {
						returnValue = mapper.writeValueAsString(employeeList.get(i));
					}
				}
				break;
				
			case "name": 
				if (value == "") {
					returnValue = mapper.writeValueAsString(employeeList);
				} else for (int i = 0; i < employeeList.size(); i++) {
					if (employeeList.get(i).getName().equals(value)) {
						returnValue = mapper.writeValueAsString(employeeList.get(i));
					}
				}
				break;
				
			default: returnValue = mapper.writeValueAsString(employeeList);
		}
		
		return returnValue;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String AddEmployee(String employee) throws JSONException, JsonGenerationException, JsonMappingException, IOException {
		
		JSONObject jObject  = new JSONObject(employee);
		
		QAEmployee qa1 = new QAEmployee(jObject.getInt("id"), jObject.getString("name"), jObject.getString("email"), jObject.getInt("age"), jObject.getBoolean("hasPatience"));

		employeeList.add(qa1);
		
		return  mapper.writeValueAsString(qa1);
	}
	
	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_JSON)
	public String EditEmployee(String employee) throws JSONException, JsonGenerationException, JsonMappingException, IOException {
		
		JSONObject jObject  = new JSONObject(employee);
				
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getId() == jObject.getInt("id")) {
				
				employeeList.get(i).updateDetails(jObject.getString("name"), jObject.getString("email"), jObject.getInt("age"), jObject.getBoolean("hasPatience"));
				
				return mapper.writeValueAsString(employeeList.get(i));
			}
		}
		
		return "";
	}
}
