package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.core.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
