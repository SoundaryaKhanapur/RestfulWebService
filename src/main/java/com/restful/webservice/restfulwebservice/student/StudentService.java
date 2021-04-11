package com.restful.webservice.restfulwebservice.student;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StudentService {
	private static List<Student> students = new ArrayList<>();
	
	private static int studentCount = 3;
	static	{
		students.add(new Student(1, "Sandy", new Date()));
		students.add(new Student(2, "Pooh", new Date()));
		students.add(new Student(3, "V", new Date()));
	}
	
	public List<Student> returnStudents() {
		return students;
	}
	
	public Student add(Student student) {
		if(student.getId() == null) {
			student.setId(++studentCount);
		}
		students.add(student);
		return student;
	}
	
	public Student find(int id) {
		for(Student student: students) {
			if(student.getId()==id) {
				return student;
			}
		}
		return null;
	}
	
	public Student deleteById(int id) {
		Iterator<Student> iterator = students.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			if(student.getId()==id) {
				iterator.remove();
				return student;
			
		}
		}
		
			
		return null;
	}
}
