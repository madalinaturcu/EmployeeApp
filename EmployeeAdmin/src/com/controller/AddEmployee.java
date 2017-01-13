package com.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.employee.QAEmployee;

@Path("/employee")
public class AddEmployee {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String DisplayEmployee() {
		
		QAEmployee qa = new QAEmployee("Mada", "Mada@gmail.com", 23, true);
		return qa.name;
	}
}
