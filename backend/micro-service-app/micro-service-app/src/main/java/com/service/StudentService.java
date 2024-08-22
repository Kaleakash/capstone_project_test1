package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> findAllStudent() {
		return studentRepository.findAll();
	}
	
	public String storeRecord(List<Student> listOfStudent) {
		studentRepository.saveAll(listOfStudent);
		return "Record stored";
	}
	
	public long getStudentCount() {
		return studentRepository.count();
	}
	
	public String addStudent(Student student) {
		Optional<Student> result = studentRepository.findById(student.getSid());
		if(result.isPresent()) {
			return "Student already present with id as "+student.getSid();
		}else {
			studentRepository.save(student);
			return "Student record stored successfully";
		}
	}
}
