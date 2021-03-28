package com.restful.webservice.restfulwebservice.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResource {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/students")
	public List<Student> retriveAllStudents(){
		return service.returnStudents();
	}
}
