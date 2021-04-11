package com.restful.webservice.restfulwebservice.student;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		Student student = service.find(id);
		if(student==null)
			throw new StudentNotFoundException("id-" +id);
		
		return student;
	}
	
	@PostMapping("/students")
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		Student addedStudent = service.add(student);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedStudent.getId()).toUri();
		//send responce status of created
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable int id) {
		Student student = service.deleteById(id);
		if(student==null)
			throw new StudentNotFoundException("id-" +id);
		
		
	}
}
