package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
     
	 // Make a own Field for Search
	public List<Student> findByfirstname(String fname);
}
