package com.restful.webservice.restfulwebservice.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResource {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/students")
	public List<Student> retriveAllStudents(){
		return service.returnStudents();
	}
	
	@GetMapping("/students/{id}")
	public Student find(@PathVariable int id) {
		return service.find(id);
	}
	
	@PostMapping("/students")
	public void createStudent(@RequestBody Student student) {
		Student addedstudent = service.add(student);
	}
}
