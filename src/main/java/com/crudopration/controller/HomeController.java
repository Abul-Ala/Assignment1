package com.crudopration.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crudopration.entity.Student;
import com.crudopration.service.Service;

@RestController
public class HomeController {

	@Autowired
	Service service;

	@GetMapping("/")
	public String index() {
		return "Application is working";
	}

	@PostMapping("/add")
	public String addStudent(@RequestBody Student student) {
		service.addStudent(student);
		return "Student is added";

	}

	@GetMapping("/get")
	public ArrayList<Student> getStudents() {

		ArrayList<Student> list = service.getStudent();
		return list;
	}

	@GetMapping("/getStudentId/{id}")
	public Student getStudentById(@PathVariable int id) {
		System.out.println("hello");
		Student student = service.getStudentById(id);
		return student;
	}

	@PutMapping("/update")
	public String updateStudent(@RequestBody Student student) {
		service.updateStudent(student);
		return "Student Updated";
	}

	@DeleteMapping("/delete")
	public String deleteStudent(@RequestBody Student student) {
		service.deleteStudent(student);
		return "Student deleted";

	}

	@DeleteMapping("/deleteStudentById/{id}")
	public String deleteStudentById(@PathVariable int id) {
		service.deleteStudentById(id);
		return "Student deleted successfully";
	}

}
