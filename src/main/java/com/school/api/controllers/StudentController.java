package com.school.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.api.model.Student;
import com.school.api.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@GetMapping("/hello")
	public String greet() {
		return "Hello hooman api is up!";
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = service.getAllStudents();
		if(students.size()==0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(students,HttpStatus.OK);
		
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Object> getStudent(@PathVariable int id){
		Student s = service.getStudent(id);
		
		if(s!=null)
			return new ResponseEntity<>(s,HttpStatus.OK);
		else
			return new ResponseEntity<>("The requested data is not present",HttpStatus.OK);
	}
	
	
	@PostMapping("/students")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		Student s = service.saveStudent(student);
		if(s!=null)
			return new ResponseEntity<>(s,HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable int id){
		Student s = service.updateStudent(student,id);
		if(s!=null)
			return new ResponseEntity<>(s,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id){
		String s = service.deleteStudent(id);
			return new ResponseEntity<>(s,HttpStatus.OK);
		
	}

}
