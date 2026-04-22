package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.core.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository respository;

	public Student createStudent(Student student) {
		return respository.save(student);
	}
	
	public List<Student> getAllStudents() {
		return respository.findAll();
	}

}
