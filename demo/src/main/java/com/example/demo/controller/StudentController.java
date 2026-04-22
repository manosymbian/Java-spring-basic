package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.core.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping
	public List<Student> getAll() {
		return service.getAllStudents();
	}
	
	@PostMapping(name = "/post")
	public Student create(@RequestBody Student student) {
		return service.createStudent(student);
	}
}
