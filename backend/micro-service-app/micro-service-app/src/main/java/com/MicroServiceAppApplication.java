package com;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.entity.Student;
import com.service.StudentService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.entity")
@EnableJpaRepositories(basePackages = "com.repository")
@EnableDiscoveryClient
public class MicroServiceAppApplication {
	
	
	@Autowired
	StudentService studentService;
	
	@PostConstruct
	public void init() {
		long count= studentService.getStudentCount();
		if(count==0) {
	List<Student> listOfStudent= Arrays.asList(new Student(1, "Steven", 34),new Student(2, "John", 32),new Student(3, "Leena", 36));
	studentService.storeRecord(listOfStudent);
	System.out.println("Student record stored..");
		}else {
			System.out.println("Record already present");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceAppApplication.class, args);
	}

}
