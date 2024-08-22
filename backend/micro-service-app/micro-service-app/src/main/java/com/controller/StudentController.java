package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.service.StudentService;

@RestController
@RequestMapping("student")
@CrossOrigin
public class StudentController {

	@Autowired
	StudentService studentServie;
	
	@GetMapping(value = "find",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> findAllStudents() {
		return studentServie.findAllStudent();
	}
	
	@PostMapping(value = "store",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeStudent(@RequestBody Student student) {
		return studentServie.addStudent(student);
	}
}
