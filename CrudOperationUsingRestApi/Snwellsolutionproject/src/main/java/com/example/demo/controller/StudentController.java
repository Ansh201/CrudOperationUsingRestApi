package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	
	// Insertion
	@PostMapping("/datasave")
	public String insertdata(@RequestBody Student student) {
		studentRepository.save(student);
		return "Your record is saved sucessfully";
	}
	// want save multiple data
	@PostMapping("/multipledatasave")
	public String insertdata(@RequestBody List<Student>student) {
		studentRepository.saveAll(student);
		return "Multiple recored saved";
	}
	

	// Now to Get Data
	@GetMapping("/getAllrecords")
	public List<Student> getStudent(){
	return ( List<Student >) studentRepository.findAll();
	}
	
	@GetMapping("/getByFirstName/{fname}") // This type we can not find data by name so in repository class we can make our own field
	public List<Student> getStudent(@PathVariable ("fname") String FirstName){
	 return ( List<Student >) studentRepository.findByfirstname(FirstName);
	}
	// Find by id is inbuilt
	@GetMapping("/getByStudentId/{id}")
	public Optional<Student> getStudentById(@PathVariable("studentId") Long id){
		return studentRepository.findById(id);
	}

	// Update Records
     @PutMapping("/updaterecords")
     public Student updatedata(@RequestBody Student student) {
    	 studentRepository.save(student);
    	 return student;
     }

     
     // Now perform Deletion Operation

     @DeleteMapping("/deleterecord/{id}")  
     public  void deleteStudent(@PathVariable("id") Long id)   
     {  
     studentRepository.deleteById(id); 
     
     }  



}	

